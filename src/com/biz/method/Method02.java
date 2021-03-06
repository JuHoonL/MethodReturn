package com.biz.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.method.VO.GradeVO;

public class Method02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		GradeVO gradeVO = new GradeVO();
		List<GradeVO> grads = new ArrayList();
		
		for(int i = 0 ; i < 3 ; i++) {
			System.out.println("현재위치 : " + i);
			GradeVO gradeVO = new GradeVO();
			if(!makeScore(gradeVO)) {	// makeScore가 실행되는 도중 문제가 발생하면 false를 return 할 것이고 i값을 1개 감소하여 다음 다시 for문으로 되돌아가서 재입력하도록 시도
//			if(makeScore(gradeVO) == false)와 같음
				i--;
				continue;
			}
			grads.add(gradeVO);					// makeScore가 정상적으로 실행되서 최종 true를 return 한 경우에는 List를 하나 추가하라는 명령어
		}
				
	}
	
	public static boolean makeScore(GradeVO gradeVO) {
		Scanner scanner = new Scanner(System.in);
		boolean retOk = true;
		
		System.out.print("학  번 : ");
		String strNum = scanner.nextLine();
		
		System.out.print("이  름 : ");
		String strName = scanner.nextLine();
		
		System.out.print("국  어 : ");
		String strKor = scanner.nextLine();
		
		System.out.print("영  어 : ");
		String strEng = scanner.nextLine();
		
		System.out.print("수  학 : ");
		String strMth = scanner.nextLine();
		
		try {
			gradeVO.setIntKor(Integer.valueOf(strKor));
			gradeVO.setIntEng(Integer.valueOf(strEng));
			gradeVO.setIntMth(Integer.valueOf(strMth));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("과목 점수 변경 오류");
			retOk = false;
		}
		return retOk ; 
	}

}
