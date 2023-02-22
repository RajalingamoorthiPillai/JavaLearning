package in.conceptarchitect.calculators;

import java.util.HashMap;

public class Calculator {
	
	HashMap<String, BinaryOperator> operators=new HashMap<String, BinaryOperator>();
	private ResultFormatter formatter;
	private ResultPresenter presenter;
	
	

	public Calculator() {
		super();
		
		formatter=(a,b,s,r)->String.format("%f %s %f = %f", a,b,s,r);
		presenter=System.out::println;
		
		
	}

	public ResultFormatter getFomatter() {
		return formatter;
	}

	public void setFomatter(ResultFormatter fomatter) {
		this.formatter = fomatter;
	}

	public ResultPresenter getPresenter() {
		return presenter;
	}

	public void setPresenter(ResultPresenter presenter) {
		this.presenter = presenter;
	}

	public void addOperator(String symbol, BinaryOperator operator) {
		// TODO Auto-generated method stub
		operators.put(symbol, operator);
	}

	public void calculate(double x, String symbol, double y) {
		// TODO Auto-generated method stub
		
		if(!operators.containsKey(symbol))
			throw new IllegalArgumentException("Invalid operator: "+symbol);
		
		var operator = operators.get(symbol);
		var result = operator.calculate(x, y);
		
		var output=formatter.format(x, symbol, y, result);
		
		
		presenter.present(output);
	}

	

}
