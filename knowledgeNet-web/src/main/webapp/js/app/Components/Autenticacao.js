define(['knockout','gateway'],
	function(ko,Gateway){

	function AuthenticationModule(){
		var self = this;
		self.lock = new Auth0Lock('stDtfDn7vNJ0Yh3j64SOjXGgFb651f3q', 'heron-oyama.auth0.com', {
	    	auth: { 
	      	params: { 
		        scope: 'openid email' 
		      }
		    }
	  	});

	  	self.tokenId = ko.observable(localStorage.id_token);

		self.lock.on("authenticated",function(authResult){
			self.lock.getProfile(authResult.idToken, function(error, profile) {
	        	if (error) { console.log("Deu ruim!"); return; }

	        	Gateway.login(profile,function(result){

	        		console.log(result);
		    		localStorage.setItem('id_token', authResult.idToken);
		    		self.tokenId(authResult.idToken);
		    		localStorage.setItem('profile',profile);
		    		localStorage.setItem('role',result.role);
		    		console.log(profile);
	    		});
	  		});
		});

		self.login  = function(){
			self.lock.show();
		},

		self.logout = function(){
			localStorage.removeItem('id_token');
    		localStorage.removeItem('profile');
    		localStorage.removeItem('role');
    		self.tokenId(null);
	  		window.location.href = window.location.origin + window.location.pathname;
		}

	};
	return new AuthenticationModule();
		
});