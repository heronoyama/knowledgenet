define(['knockout'],function(ko){

	ko.components.register('cobranca-table', {
	    viewModel: {require: 'gadgets/models/CobrancaTable'},
	    template: {require: 'text!gadgets/templates/cobrancaTable.html'}
	});

	ko.components.register('mensagem', {
	    viewModel: {require: 'gadgets/models/Mensagem'},
	    template: {require: 'text!gadgets/templates/mensagem.html'}
	});

	ko.components.register('pie-chart', {
	    viewModel: {require: 'gadgets/models/PieChart'},
	    template: {require: 'text!gadgets/templates/pie.html'}
	});

	ko.components.register('line-chart', {
	    viewModel: {require: 'gadgets/models/LineChart'},
	    template: {require: 'text!gadgets/templates/line.html'}
	});

	ko.components.register('bars-chart', {
	    viewModel: {require: 'gadgets/models/BarsChart'},
	    template: {require: 'text!gadgets/templates/bars.html'}
	});


});