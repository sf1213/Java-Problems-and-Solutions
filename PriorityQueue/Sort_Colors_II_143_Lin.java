package Priority_Queue;

public class Sort_Colors_II_143_Lin {
	public void sortColors2(int[] colors, int k) {
        if(colors == null || colors.length == 0){
            return;
        }
        
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }
    
    private void rainbowSort(int[] colors, int indexFrom, int indexTo, int colorFrom, int colorTo){
        if(colorFrom == colorTo){
            return;
        }
        
        int pivot = colorFrom + (colorTo - colorFrom) / 2;
        int left = indexFrom - 1, right = indexTo + 1;
        while(left < right){
            do{ left++; } while( left < right && colors[left] <= pivot);
            do{ right--; } while(left < right && colors[right] > pivot);
            
            if(left < right){
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
            }
        }
        
        rainbowSort(colors, indexFrom, right, colorFrom, pivot);
        rainbowSort(colors, left, indexTo, pivot + 1, colorTo);
    }
}
