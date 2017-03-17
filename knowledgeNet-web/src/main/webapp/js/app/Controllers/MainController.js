define(['knockout','components/EstrategiaBuscaCobranca','chart'],function(ko,EstrategiaBuscaCobranca,chart){ 
	//TODO após renomear ListController para SimpleController, fazer ele extender
	var MainController = {}

	MainController.model = 
		function MainController(){
			var self = this;

		};

	MainController.load = function(element,templateLocation,htmlSection,model){
		$(element).load(templateLocation,
		 function(){
	 			ko.applyBindings(model, getElement(htmlSection));
		 	}	
		 );
	};

	return MainController;
});