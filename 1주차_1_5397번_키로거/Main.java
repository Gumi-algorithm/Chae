package com.ssafy.list;

import java.util.Scanner;


//연결리스트 구현에 어려움이 있어 예시 코드를 사용하였습니다.

class LinkedList {
	private Node head;
    private Node tail;
    private int size;

    static class Node{
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }    

        public String toString(){
            return String.valueOf(this.data);
        }
    }
    
    public void addFirst(Object data){ // 첫부분에 add
        Node newNode = new Node(data);

        newNode.next = head;
        head=newNode;

        size++;
        if(head.next == null){
            tail = head;
        }
    }
       
    public void addLast(Object data){ // 마지막에 add
        Node newNode = new Node(data);

        if(size == 0){
            addFirst(data);
        }
        else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }
    
    public Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }
    
    
    public void addMiddle(Object data, int idx){ // 중간에 add

        if(idx == 0){
            addFirst(data);
        }
        else{
            Node tmp_1 = node(idx-1);
            Node tmp_2 = tmp_1.next;
            Node newNode = new Node(data);

            tmp_1.next = newNode;
            newNode.next = tmp_2;
            size++;

            if(newNode.next == null){
                tail = newNode;
            }
        }
    }
    
    public Object remove(int idx){ // 특정 인덱스 노드 삭제
        if(idx == 0){
            return removeFirst();
        }
        Node tmp = node(idx-1);
        Node willDelete = tmp.next;
        tmp.next = tmp.next.next;

        Object data = willDelete.data;
        if(willDelete == tail){
            tail = tmp;
        }
        willDelete = null;
        size--;

        return data;
    }
      
    public Object removeFirst(){ // 첫부분 삭제

        Node tmp = head;
        head = head.next;
        Object data = tmp.data;
        tmp = null;
        size--;
        return data;
    }
      
    public Object removeLast(){ // 마지막 부분 삭제

        Node tmp = tail;
        tail = node(size-2);
        tail.next=null;
        Object data = tmp.data;
        tmp = null;
        size--;
        return data;
    }
     
    public Object getNode(int idx){ // 특정 인덱스 노드의 데이터 반환
        return node(idx).data;
    }

    public Object getFirst(){ // 첫부분의 데이터 반환
        return head.data;
    }

    public Object getLast(){ // 마지막 부분의 데이터 반환
        return tail.data;
    }
    
    public int getIndex(Object data){ // 특정 데이터의 인덱스 반환
        Node tmp = head;
        int idx = 0;
        while(tmp.data != data){
            tmp = tmp.next;
            idx++;
            if(tmp == null)
                return -1;
        }
        return idx;
    }  
    
    public boolean isEmpyt(){ // 리스트가 비었는지 반환
        if(size == 0)
            return true;
        return false;
    }

    public int getSize(){ // 리스트의 사이즈 반환
        return size;
    }

    public void clear(){ // 리스트 초기화
        while(size>0){
            removeFirst();
        }
    }    
    
    public String toString(){ // 리스트 출력을 위한 문자열 반환
        if(head == null){
            return null;
        }
        Node tmp = head;
        String str = "";
        while(tmp.next != null){
            str += tmp.data;
            tmp = tmp.next;
        }

        str+= tmp.data;
        return str;
    }
}


public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt(); // 테스트 케이스 수 입력
		String[] rst = new String[testCase]; // 결과 출력을 위한 문자열 배열 선언
		
		for(int i = 0; i < testCase; i++)
		{
			LinkedList linkedList = new LinkedList();    // 연결 리스트 생성
			String[] s = sc.next().split(""); // 문자열 한글자씩 분리
			char[] arr = new char[s.length]; // 한글자의 문자열을 char타입으로 저장하기 위한 배열 선언
			int cnt = 0;
			for(int j = 0; j < s.length; j++)
			{		
				arr[j] = s[j].charAt(0); // 한글자의 문자열을 char형식으로 변환
				if(arr[j] == '-')
				{
					//삭제
					if(cnt < 0) { // cnt가 음수일 경우는 <을 사용하였을 때
						int num = linkedList.getSize() - 1 + cnt;
						linkedList.remove(num);
						continue;				
					}
					else 
					{
						linkedList.removeLast();
						continue;
					}
					
				}
				else if(arr[j] == '<')
				{
					if(linkedList.getSize() != 0 && linkedList.getSize() - cnt > 0) 
					{
						cnt--;
						continue;
					}
				}
				else if(arr[j] == '>')
				{
					if(linkedList.getSize() != 0 && linkedList.getSize() != linkedList.getIndex(linkedList.getLast()))
					{
						cnt++;
						continue;
					}
				}
				else
				{
					if(cnt < 0) { // cnt가 음수일 경우는 <을 사용하였을 때
						int num = linkedList.getSize() + cnt;
						linkedList.addMiddle(s[j],num);
					}
					else 
						linkedList.addLast(s[j]);
				}
			}   		 
			rst[i]	= linkedList.toString();	
		}
		sc.close();
		for(int k = 0; k < testCase; k++)
		{
			System.out.println(rst[k]);
		}		
	}
}


// 테스트 케이스에 대한 결과는 잘 출력되나 런타임 오류가 계속 뜨는 상황입니다.
