package com.mycom.word;

import com.mycom.word.ICRUD;
import com.mycom.word.Word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    ArrayList<Word> list;
    Scanner s;
    //final Stirng fname = "Dictionary.txt";
    /*
     * => 난이도 (1,2,3) & 새 단어 입력 : 1 driveway
     * 뜻 력 : 차고 진입로
     * 새 단어가 단어장 추가되었습니다.
     * */

    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;

    }
    @Override
    public Object add() {
        System.out.print("난이도 (1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String word = s.nextLine();

        // 1 driveway
        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();


        //차고 진입
        // TODO Auto-generated method stub
        return new Word(0,level,word,meaning);
    }

    public void addItem() {
        Word one = (Word)add();
        list.add(one);
        System.out.println("새 단어가 단어장 추가되었습니다. ");

    }

    @Override
    public int update(Object obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Object obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int selectOne(int id) {
        // TODO Auto-generated method stub
        return 0;
    }

    public ArrayList<Integer> listAll(String keyword) {

        ArrayList<Integer> idlist = new ArrayList<>();
        int j =0;
        System.out.println("--------------------------");
        for(int i = 0; i<list.size(); i++ ) {
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print((j+1) + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("--------------------------");
        return idlist;

    }

    public void listAll() {
        System.out.println("--------------------------");
        for(int i = 0; i<list.size(); i++ ) {
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------");

    }

    public void updateItem() {
        System.out.print("=> 수정할 단어 검색 : ");
        String keyword = s.next(); //s.next는 공백을 허용하지 않게 하기 위하여 사용
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 수정할 번호 검색 : ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("=> 뜻 입력 : ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.println("단어가 수정되었습니다. ");
    }

    public void deleteItem() {
        System.out.print("=> 삭제 할 단어 검색 : ");
        String keyword = s.next(); //s.next는 공백을 허용하지 않게 하기 위하여 사용
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 삭제 할 번호 검색 : ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("=> 정말로 삭제하실래요?(Y/n) ");
        String ans = s.next();
        if(ans.equalsIgnoreCase("y")) {
            list.remove((int)idlist.get(id-1));
            System.out.println("단어가 샥제 되었습니다. ");
        }
        else
            System.out.println("취소 되었습니다. ");


    }

//	public void loadFile() {
//		BufferedReader br = new BufferedReader(new FileReader
//				((fname));
//	}
}
