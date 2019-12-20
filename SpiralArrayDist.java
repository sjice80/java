import java.util.Scanner;

public class SpiralArrayDist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       //      1부터 차례대로 다음과 같이 정렬했을 때, 
        //      숫자 N(1 <= N <= 10^9)을 입력받아서 
        //      1부터 N까지 가는 최단거리를 계산하는 프로그램을 작성하세요. 
        //      (상, 하, 좌, 우로만 움직일 수 있고 대각선으로는 움직일 수 없다.)

        Scanner sc = new Scanner(System.in);

        int[][] arr;
        int size = 0;//크기
        int num = 1;//시작수
        int x = 0;//x축
        int y = 0;//y축
        System.out.print("홀수만 입력: ");
        size = sc.nextInt();
        arr = new int[size][size];//사용자가 지정한 사이즈

        x = size/2;
        y = size/2;
        //정중앙에서 시작



        int a = 1;//순서변수
        int sum = 1;//한줄로 숫자를 생성하기위한 변수

        arr[y][x] = num;
        //변의길이에 따른 나선배열 생성
        outer : while(num <= size*size) {


            for(int i = 0; i < sum; i++) {
                if(a == 1) { 
                	x += 1; 
                	num++; 
                	if(num == size*size+1) {
                		break outer;
                	}//규격외로 넘어가는 숫자생성 방지 
                	arr[y][x] = num; 
                }//오른쪽으로 생성
                if(a == 2) { 
                	y -= 1; 
                	num++; 
                	arr[y][x] = num;
                }//위로 생성              
            }//for

            for(int i = 0; i < sum; i++) {
                if(a == 3) { 
                	x -= 1; 
                	num++; 
                	arr[y][x] = num;
                }//왼쪽으로생성
                if(a == 4) { 
                	y += 1; 
                	num++; 
                	arr[y][x] = num;
                }//아래로 생성
            }//for


            if( a == 4 ) {
                a = 1;
                sum++;
            } else if( a == 2) {
                sum++;
                a++;
            } else if( a==3 || a==1 ) {
                a++;
            }//진행순서 설정


        }//while

        //배열 출력 코드
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"    ");
            }//inner
            System.out.println();
        }//output


        System.out.println("-------------------------------");



        int number = 0;
        System.out.println("5번 측정하세요");
        while(number != 5) {

            System.out.print("1에서 거리를 측정할 숫자 값: ");

            int n = sc.nextInt();
            int xLength;
            int yLength;

            for (int i = 0; i < arr.length; i++) {

                for (int j = 0; j < arr[i].length; j++) {   
                    if(n == arr[i][j]) {

                        if( i >= (size/2) ) {

                            yLength = i-(size/2);
                        }else{
                            yLength = (size/2)-i;
                        }//y값 거리측정

                        if( j >= (size/2) ) {
                            xLength = j-(size/2);
                        }else {
                            xLength = (size/2)-j;
                        }//x값 거리측정
                        System.out.println( xLength + yLength );
                    }//if

                }//inner

            }//outer
            number++;
        }//while


	}

}
