// Afshin.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "iostream"
#include "conio.h"
using namespace std;


int main()
{
	double a,b;
	int select;
	outer: while(true){
		cout<<"Lotfan adade awal ra wared konid: \n-> ";
		cin>>a;
		cout<<"lotfan adade dovom ra vared kONID: \n-> ";
		cin>>b;
		while(true){
			double result;
			cout<<"Lotfan amalyate khod ra entekhab konid :\n"
				"1- +\n"
				"2- -\n"
				"3- *\n"
				"4- /\n"
				"5- %\n";
			cin>>select;
			switch(select){
				case 1: result=a+b;break;break;
				case 2: result=a-b;break;
				case 3: result=a*b;break;
				case 4: result=a/b;break;
				case 5: result=(int)a%(int)b;break;
				default:
					cout<<"error.lotfan meghdare sahih ra entekhab konid\n";					
					continue;
			}//switch
			cout<<"Natijeye amalyat barabar ast ba: "<<result;
			getch();
			break;
		}//inner while
		cout<<"\naya mikhahaid edame dahid: 1- bale	2- kheyr\n";
		cin>>select;
		if(select==1){ system("cls");}
		else break;	
	}//while
	return 0;
}

