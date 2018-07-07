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
	
	
	//Pascal's Triangle II-ArrayList
	public List<Integer> getRow(int rowIndex) {
        List<Integer> row=new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++){
            //row.add(0,1);  // cost O(N)
            for(int j=i-1;j>0;j--){    //from right to left
                row.set(j,row.get(j)+row.get(j-1));
            }
            row.add(1);   // cost O(1)
        }
        return row;
    }
	//Pascal's Triangle II-Arrays
	public List<Integer> getRow(int rowIndex) {       
        Integer[] row=new Integer[rowIndex+1];
        Arrays.fill(row,1);
        for(int i=1;i<rowIndex;i++){           
            for(int j=i;j>0;j--){    //from right to left              
                row[j]+=row[j-1];
            }          
        }
        return Arrays.asList(row);
    }
	
}
