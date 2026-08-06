class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        

        int n =bills.length;
        for(int i =0;i<n;i++){
            int money =bills[i];


            if(money==5){
                five++;

            }
           else if(money==10){
                if(five==0)
                return false;

                five--;
                ten++;
            }
        else if(money==20){
                if(ten>0){
                    ten--;

                    if(five>0){
                         five--;
                    }
                    else{
                        return false ;
                    }
                   


                }
                else{
                   if (five<3)
                return false ;
                else{
 five=five-3;
                }

               
                
            }
        }}return true;
    }
}