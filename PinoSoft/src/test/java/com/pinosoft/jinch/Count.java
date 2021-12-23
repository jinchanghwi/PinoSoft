package com.pinosoft.jinch;

public class Count extends Thread{
	int k;
	public Count(int i) {
		k=i;
	}

	public void run() {

			System.out.println("쓰레드 시작 : " + k);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("쓰레드 끝 : " + k);
		}
	}

