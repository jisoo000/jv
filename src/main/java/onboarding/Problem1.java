package onboarding;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        System.out.println("[실행] solution() start...");
        int answer = Integer.MAX_VALUE;

        //요구사항 예외설정
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){
            answer = -1;
            System.out.print("예외 발생");
            return answer;
        }

        int pobiScore = Math.max(sumMax(pobi), multiplyMax(pobi));
        int crongScore = Math.max(sumMax(crong),multiplyMax(crong));

        //결과값
        try {
            if (pobiScore > crongScore)
                answer = 1;
            if (pobiScore < crongScore)
                answer = 2;
            if (pobiScore == crongScore)
                answer = 0;
        }catch (Exception e) {
            System.out.print("예외 발생");
        }

        System.out.println("포비" + pobiScore + "점, 크롱" + crongScore + "점. 게임결과(0:무승부 1:포비승 2:크롱승) =>" + answer + "\n");
        return answer;
    }

    //덧셈최고값 산출함수
    static private int sumMax(List<Integer> value) {
        int leftPageCalMax = 0;
        int rightPageCalMax = 0;

        String[] arr1 = String.valueOf(value.get(0)).split("");
        for (String s : arr1) {
            leftPageCalMax += Integer.parseInt(s);
        }

        String[] arr2 = String.valueOf(value.get(1)).split("");
        for (String s : arr2) {
            rightPageCalMax += Integer.parseInt(s);
        }

        System.out.print(value + "왼쪽페이지합:" + leftPageCalMax + " 오른쪽페이지합:" + rightPageCalMax );
        System.out.print("최고합:" + Math.max(leftPageCalMax, rightPageCalMax) + "\n");
        return Math.max(leftPageCalMax, rightPageCalMax);
    }

    //곱셈최고값 산출함수
    static private int multiplyMax(List<Integer> value) {
        int leftPageCalMax = 1;
        int rightPageCalMax = 1;

        String[] arr1 = String.valueOf(value.get(0)).split("");
        for (String s : arr1) {
            leftPageCalMax *= Integer.parseInt(s);
        }

        String[] arr2 = String.valueOf(value.get(1)).split("");
        for (String s : arr2) {
            rightPageCalMax *= Integer.parseInt(s);
        }

        System.out.print("왼쪽페이지곱:" + leftPageCalMax + " 오른쪽페이지곱:" + rightPageCalMax );
        System.out.print("최고곱:" + Math.max(leftPageCalMax, rightPageCalMax) + "\n");
        return Math.max(leftPageCalMax, rightPageCalMax);
    }
}