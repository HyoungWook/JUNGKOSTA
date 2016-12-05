package jungkosta.commons.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jungkosta.main.domain.CustomPreferVO;

public class PreferCustomTool {
	
	private static PreferCustomTool tool = new PreferCustomTool();
	
	public static PreferCustomTool getInstance(){
		
		return tool;
		
	}
	
	public Integer [][] makeMatrix(int row, int col){
		
		Integer [][] i_Matrix = new Integer[row][col];
		
		for(int i = 0 ; i < row ; i++)
		{
			for(int j = 0 ; j < col ; j++){
				i_Matrix[i][j] = 0;
			}
		}
		return i_Matrix;
		
	}
	
	public String [] makeArr(Set<String> set){
		
		String [] arr = new String[set.size()];
		
		int i = 0;
		
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()){
			
			arr[i++] = iter.next();
		}
		
		return arr;	
			
	}
	
	public Integer searchIndex(String [] arr, String str){
		
		for(int index = 0 ; index < arr.length ; index++){
			
			if(arr[index].equals(str)){
				return index;
			}
		}
		
		return null;
	}
	
	
	public Integer [][] setMatrix(Integer [][] matrix, String [] users,
			String [] items,List<CustomPreferVO> list){
		
		String user = null;
		String item = null;
		
		CustomPreferVO vo = null;
		Integer itemIndex = null;
		Integer userIndex = null;
		
		for(int index = 0 ; index < list.size() ; index++){
			
			vo = list.get(index);
			
			user = vo.getEmail();
			item = ((Integer)vo.getSale_id()).toString();
			
			itemIndex = searchIndex(items, item);
			userIndex = searchIndex(users, user);
			
			
			matrix[userIndex][itemIndex] = vo.getView_num();
			
			
		}
		
		return matrix;
	}
	
	public Double [][] Normalization(Integer [][] matrix,int row, int col){
		
		Double [][] d_matrix = new Double[row][col];
		Double [] denominator = new Double[row];
		
		for(int i = 0 ; i < row ; i++){
			denominator[i] = this.denominator(matrix[i]);
		}
		
		for(int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < col ; j++){
				d_matrix[i][j] = matrix[i][j]/denominator[i];
			}
		}
		
		return d_matrix;
		
	}
	
	public Double denominator(Integer [] arr){
		
		Double result = 0.0;
		double temp = 0;
		
		for(int i = 0 ; i < arr.length ; i++){
			temp += (arr[i]*arr[i]);
		}
		
		result = Math.sqrt(temp);
		
		return result;
		
	}
	
	public Double [] calculatePrefer(Double [][] d_Matrix, int userSize , Integer userIndex){
		
		Double [] resultValues = new Double[userSize];
		Double temp = 0.0;
		
		for(int i = 0 ; i < userSize ; i++){
			temp = 0.0;
			for(int j = 0 ; j < d_Matrix[i].length ; j++){
				temp += (d_Matrix[userIndex][j] * d_Matrix[i][j]);
				
			}
			resultValues[i] = temp;
			
		}
		
		return resultValues;
		
	}
	
	public Integer findSimilarPerson(Double [] resultValues, Integer userIndex){
		
		
		Double similarPerson = 0.0;
		Integer similarPersonIndex = null;
		
		for(int i = 0 ; i < resultValues.length ; i++){
		
			if(i == userIndex)
				continue;
			
			if(similarPerson < resultValues[i])
			{
				similarPerson = resultValues[i];
				similarPersonIndex = i;
			}
			
		}
		
		return similarPersonIndex;
	}
}
