#include <stdio.h>
#include <stdlib.h>

int* twoSum(int* nums, int numsSize, int target) {
 	int i =0 ,j = 0;
 	int *result;
 	result = (int *)malloc(sizeof(int)*2);
 	for( i =0;i<numsSize;i++){
 		for(j=i+1;j<numsSize;j++){
 			if(nums[i]+nums[j] == target){
 				result[0] = i;
 				result[1] = j;
 			}
 		}
 	}
 	return result;
}

int main(){
	int num[] = {2,7,11,15};
	int *result = twoSum(num,4,9);
	printf("%d\n",result[0]);
	printf("%d\n",result[1]);
	return 0;
}