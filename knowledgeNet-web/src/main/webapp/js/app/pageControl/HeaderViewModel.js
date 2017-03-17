define(['knockout','app/pageControl/ListPage','app/pageControl/StaticPage','app/pageControl/ViewPage',
	'controllers/MainController',
	'controllers/DespesasRecorrentesListController',
	'controllers/DespesasRecorrentesViewController',
	'controllers/MesesCobrancaListController',
	'controllers/MesCobrancaViewController',
	'controllers/RelatorioController'],
	function(ko,ListPage,StaticPage,ViewPage,
	MainController,
	DespesasRecorrentesListController,
	DespesasRecorrentesViewController,
	MesesCobrancaListController,
	MesCobrancaViewController,
	RelatorioController){
 return function HeaderViewModel(auth,definedPages){
	var self = this;

	self.autenticacao = ko.observable(auth);
	self.pages = ko.observableArray(definedPages.pages());
	self.currentPage = ko.observable();
	self.visiblePages = ko.computed(function(){
		if(!self.autenticacao().tokenId())
			return [];
		return $.grep(self.pages(),function(element){
			return element.isMenuVisible()}
		);
	});
	
	self.setPage = function(page,view){
		 pageToLoad = getPage(page,view);
		 pageToLoad.load('#content');
	};

	self.setPage = function(page,view,id){
		 pageToLoad = getPage(page,view);
		 pageToLoad.load('#content',id);
	};

	function getPage (page, view){
		var pagesToLoad  = $.grep(self.pages(), function(element){
	        	return element.page == page && element.view == view;
	        	//check methods from knockout
	        }); //TODO is fucking ugly
		 var pageToLoad = pagesToLoad[0];
		 if(!pageToLoad) //TODO
			 console.log('TODO: Tratamento 404');
		 self.currentPage(pageToLoad);
		 return pageToLoad;
	}

 };
});