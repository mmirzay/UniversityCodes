#include "stdafx.h"
#include <iostream>
#include <iomanip>
#include <stdlib.h>
#include <stdio.h>
#include <conio.h>
#include <fstream>
#include <math.h>
using namespace std;
struct student{
	char name[30];
	char family[30];
	char branch[30];
	long id;
	char entrance_date[30];
}*st, *arr;
 void show_menu();
 void add_information();
 int search();
 void display();
 void sort_information();
 void showallinformation();
 void edit();
 int n_o_s;//n_o_s = number of student 
void main()
{
	cout <<"*****************************************************************************"<<endl<<endl;
	cout<<"   *'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*"<<endl<<endl;
	cout<<"     *'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*''*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'"<<endl<<endl;
	cout<<"       *'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'"<<endl<<endl;
	cout<<"         *'*'*'*'*'*'*'*'*' >> wellcome to my program << '*'*'*'*'*'*"<<endl<<endl;
	cout<<"           *'*'*'*'*'*''*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*"<<endl<<endl;
	cout<<"             *'*''*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'*'"<<endl<<endl;
	cout<<"               *'*'*'*'*'*'*'*'*'*'*'*''*'*'*'*'*'*'*'*'*'*'"<<endl<<endl;
	cout<<"                 *'*'*'*'*'*'*'*''*'*'*'*'*'*'*'*'*'*'*'*"<<endl<<endl;
	cout<<"                   *'*'*'*'*'*'*'*''*'*'*'*'*'*'*'*'*'*"<<endl<<endl;
	cout<<"                     *'*'*'*'*'*'*'*''*'*'*'*'*'*'*'*"<<endl<<endl;
	cout <<"to start, press one key "<<endl<<endl;
	getch();	
	while(1){
		int number;
		system("cls");
		show_menu();
		cin>>number;	
		switch(number)
		{
		case 1 :add_information();break;			
		case 2 :
			{
				cout <<search()<<endl;
				getch(); 								
			}
			break;
		case 3 :display();break;			
		case 4 : edit();break;		
		case 5 :break;
		case 6 :showallinformation();break;			
		case 7 :  return; break;	
		}//switch
		getch();
	}//while	
}
void show_menu()
{
	cout <<"enter one number from this list to start program (1-7): "<<endl;
	cout<<"*************************************************************************\n";
	cout <<" 1-> to  add information to array"<<endl;
	cout <<" 2-> to  search information of one student"<<endl;
	cout <<" 3-> to  display information of one student"<<endl;
	cout <<" 4-> to  edit information of one student"<<endl;
	cout <<" 5-> to  sort information of student"<<endl;
	cout <<" 6-> to  display information of all student"<<endl;
	cout <<" 7-> to  exit"<<endl;
	cout<<"- ";	
}
void add_information()
{	
	cout<<"enter number of students : "<<endl;
	cin>>n_o_s;
	st = new student[n_o_s];	
	ofstream stfile("student.txt");
	for(int i=0;i<n_o_s;i++){
		cout << "enter name of "<<i+1<<" omin student : "<<endl;
		cin>>st[i].name;
		stfile<<st[i].name<<'\t';
		cout << "enter family of "<<i+1<<"omin student : "<<endl;
		cin>>st[i].family;
		stfile<<st[i].family<<'\t';
		cout << "enter branch of "<<i+1<<"omin student : "<<endl<<endl;
		cin>>st[i].branch;
		stfile<<st[i].branch<<'\t';
		cout << "enter id of "<<i+1<<"omin student : "<<endl<<endl;
		cin>>st[i].id;		
		stfile<<st[i].id<<'\t';
		cout << "enter entrance_date of "<<i+1<<"omin student : "<<endl<<endl;
		cin>>st[i].entrance_date;
		stfile<<st[i].entrance_date<<'\t';
	}
	stfile.close();
}

int search()
{
	long key;
	student st_temp;
	ifstream stfile("student.txt");
	cout<<"lotfan shomare daneshjuii (id) ra vared konid "<<endl;
	cin>>key;
	int i=1;
	while(!stfile.eof())
	{
		stfile>>st_temp.name;
		stfile>>st_temp.family;
		stfile>>st_temp.branch;
		stfile>>st_temp.id;
		stfile>>st_temp.entrance_date;
		if((st_temp.id)==key)
		{			
			return i;	
		}
		i++;
	}
	stfile.close();
	return -1;
}
void display () 
{
	int user_choese,found=0;
	ifstream stfile("student.txt");
	student st_temp2;
	cout<<"enter student id : "<<endl;
	cin>>user_choese;
	while(!stfile.eof())
	{			
		stfile>>st_temp2.name;
		stfile>>st_temp2.family;
		stfile>>st_temp2.branch;
		stfile>>st_temp2.id;
		stfile>>st_temp2.entrance_date;
		if((st_temp2.id)==user_choese)
		{		
		found=1;	
		cout<<"the information of student is : "<<endl;
		cout<<"name : "<<st_temp2.name<<endl;
		cout<<"family : "<<st_temp2.family<<endl<<endl;
	cout<<"branch : "<<st_temp2.branch<<endl<<endl;
	cout<<"id : "<<st_temp2.id<<endl<<endl;
	cout<<"entrance_date : "<<st_temp2.entrance_date<<endl<<endl;
	break;
	}
	
	}
	stfile.close();
	if(found==0){cout <<"there is no studnt with this id ("<<user_choese<<")"<<endl<<endl;}
}


void sort_information()
{	
	student st_temp3;
	int counter=0;
	ifstream stfile("student.txt");	
	while(!stfile.eof())
	{
			
		stfile>>st_temp3.name;
		stfile>>st_temp3.family;
		stfile>>st_temp3.branch;
		stfile>>st_temp3.id;
		stfile>>st_temp3.entrance_date;		
		counter++;

	}		
	n_o_s=counter;
	arr=new student[n_o_s];
	for(int i=0;i<n_o_s;i++)
	{
			
		stfile>>st_temp3.name;
		stfile>>st_temp3.family;
		stfile>>st_temp3.branch;
		stfile>>st_temp3.id;
		stfile>>st_temp3.entrance_date;		
		arr[i]=st_temp3;
	}
	cout<<"befor \n";
	for(int i=0;i<n_o_s;i++)
		cout<<arr[i].name<<"  "<<arr[i].family<<"  "<<arr[i].branch;//<<"  "<<arr[i].id<<"  "<<arr[i].entrance_date<<"\n";
	student  temp3;
	for(int i=0;i<n_o_s;i++)
	{
	for(int j=1+i;j<n_o_s-1;j++)
		if(arr[j].id<arr[i].id)
	{
	temp3=arr[j];
	arr[j]=arr[i];
	arr[i]=temp3;
	}	
	}
	cout<<"after \n";
	for(int i=0;i<n_o_s;i++)
		cout<<arr[i].name;//<<"  "<<arr[i].family<<"  "<<arr[i].branch<<"  "<<arr[i].id<<"  "<<arr[i].entrance_date<<"\n";
}




void showallinformation()
{
	student st_temp3;
	ifstream stfile("student.txt");	
	cout<<"the information of student is : "<<endl<<endl<<endl;	
	while(!stfile.eof())
		{
	stfile>>st_temp3.name;
	stfile>>st_temp3.family;
	stfile>>st_temp3.branch;
	stfile>>st_temp3.id;
	stfile>>st_temp3.entrance_date;		
		
	
	cout<<"name : "<<st_temp3.name<<endl<<endl;
	cout<<"family : "<<st_temp3.family<<endl<<endl;
	cout<<"branch : "<<st_temp3.branch<<endl<<endl;
	cout<<"id : "<<st_temp3.id<<endl<<endl;
	cout<<"entrance_date : "<<st_temp3.entrance_date<<endl<<endl;
	
}
	stfile.close();
}



void edit()
{
	student st_temp3;
ifstream stfile("student.txt");
search();

/*stfile>>st_temp3.name;
	stfile>>st_temp3.family;
	stfile>>st_temp3.branch;
	stfile>>st_temp3.id;
	stfile>>st_temp3.entrance_date;		*/
	
}