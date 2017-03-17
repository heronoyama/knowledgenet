require(['knockout','sammy','app/components',
	'components/Autenticacao',
	'app/pageControl/DefinedPages',
	'app/pageControl/HeaderViewModel'], 
	function(ko, Sammy,components,
	auth,
	DefinedPages,
	HeaderViewModel) {

	requirejs('app/components');
	
	ko.applyBindings(auth, getElement('ProfileController'));

	var definedPages = new DefinedPages(auth);

	var headerModel  = new HeaderViewModel(auth,definedPages);
	ko.applyBindings(headerModel,getElement('headerController'));

	Sammy(function (){
		this.notFound = function(){};
		this.get('#:page/:view',function(){
			headerModel.setPage(this.params['page'],this.params['view']);
		});

		this.get('#:page/:view/:id',function(){
			headerModel.setPage(this.params['page'],this.params['view'],this.params['id']);
		});


	}).run(definedPages.defaultPage().getUrl());

	 

});