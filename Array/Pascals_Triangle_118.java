package Array;

public class Pascals_Triangle_118 {
//normal way
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal=new ArrayList<>();       
        for(int i=0;i<numRows;i++){
            List<Integer> rowList=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    rowList.add(1);
                }else{
                    rowList.add(pascal.get(i-1).get(j-1)+pascal.get(i-1).get(j));
                }
            }
            pascal.add(rowList);
        }
        return pascal;
    }
//clever but slower
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int i = 0; i < numRows; i++) {
			row.add(0, 1);
			for (int j = 1; j < row.size() - 1; j++)
				row.set(j, row.get(j) + row.get(j + 1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;

	}
}
