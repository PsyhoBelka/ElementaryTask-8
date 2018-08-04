package ua.rozhkov;

public class FibonachiSeq {

	private String[] getParameters(String input) {
		String divider = "";
		if (input.contains(" ")) {
			divider = ", ";
		} else if (input.contains(",")) {
			divider = " ";
		} else if (input.contains(", ")) {
			divider = ",";
		}
		return input.split(divider);
	}

	public String formSeq(String input) {
		String[] param=getParameters(input);
		if (param.length == 1) {
			int lenElem;
			try {
				lenElem = Integer.parseInt(input);
			}
			catch (NumberFormatException e) {
				throw new NumberFormatException("Wrong length!");
			}
			return String.valueOf(fibonachiLen(lenElem));
		} else {
			double paramLeft;
			double paramRight;
			try {
				paramLeft=Double.parseDouble(param[0]);
				paramRight=Double.parseDouble(param[1]);
			}
			catch (NumberFormatException e) {
				throw new NumberFormatException("Wrong range!");
			}
			return String.valueOf(fibonachiRange(paramLeft,paramRight));
		}
	}

	private String fibonachiRange(double min, double max) {
		double fibonachi = 0;
		int i = 0;
		String result = "";
		while (fibonachi < max) {
			fibonachi = fibonachi(i);
			if ((fibonachi >= min)&&(fibonachi<=max)) {
				result += String.format("%.0f", fibonachi)+" ";
			}
			i++;
		}

		return result.trim();
	}

	private String fibonachiLen(int length) {
		double fibonachi = 0;
		int i = 0;
		String result = "";
		while (String.valueOf(Math.round(fibonachi)).length() <= length) {
			fibonachi = fibonachi(i);
			if (String.valueOf(Math.round(fibonachi)).length() == length) {
				result += String.format("%.0f", fibonachi) + " ";
			}
			i++;
		}

		return result.trim();
	}

	private double fibonachi(int n) {
		return Math.round((Math.pow((1 + Math.sqrt(5)) / 2, n)) / Math.sqrt(5));
	}

	//вывод ряда Фибоначи до n
	public void fibonachiN(int n) {
		if (n <= 100) {
			for (int i = 1; i <= n; i++) {
				if (n <= 1) {
					System.out.print("1");
				} else {
					double fibonachi = fibonachi(i);
					System.out.printf("%.0f", fibonachi);
					System.out.print(" ");
				}
				if (i % 10 == 0) {
					System.out.println();
				}
			}
		} else {
			System.out.println("Too much numbers!");
		}
	}
}
