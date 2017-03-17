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
	RelatorioController	){
	 return function DefinedPages(auth){
	 	var self = this;

	 	self.defaultPage = function(){ return new ListPage({auth: auth,page: 'Main', controller:MainController, htmlSection:'MainView', view:'welcome'}); };

	 	self.pages = function(){
			return [ 
			  self.defaultPage()/*,
			  new ListPage ({auth: auth, page: 'DespesasRecorrentes', controller: DespesasRecorrentesListController, htmlSection:'DespesasList', view: 'list'}),
			  new ViewPage ({auth: auth, page: 'DespesasRecorrentes', controller: DespesasRecorrentesViewController, htmlSection:'DespesaView', view: 'view'}),
			  new ListPage ({auth: auth, page: 'MesesCobranca', controller: MesesCobrancaListController, htmlSection:'MesesList', view: 'list'}),
		  	  new ViewPage ({auth: auth, page: 'MesesCobranca', controller: MesCobrancaViewController, htmlSection:'MesCobrancaView', view: 'view'}),
		  	  new ListPage ({auth: auth, page: 'Relatorios', controller: RelatorioController, htmlSection:'RelatorioView', view: 'view'})
			*/];};

	 }
 });