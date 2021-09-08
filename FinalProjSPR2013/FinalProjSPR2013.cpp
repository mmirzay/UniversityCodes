// mehran mohamadi - shomare danshjuii:9017050240

#include "stdafx.h"
#include "iostream"
#include "fstream"
#include "conio.h"
#include "fstream"
using namespace std;

struct phonBook{	
	char name[20];
	char family[20];	
	char telNum[11];
}*pb;
static int index=0;
static int maxNum=0;
void infoNum(){
	system("cls");	
	cout<<"===============================================================================\n";
	cout<<" How many Contact do you want to add to your Phone Book? \n";	
	cout<<"===============================================================================\n";
	cout<<"-> ";
	cin>>maxNum;	
}
void addInfo(){		
	phonBook *pbTemp=new phonBook[maxNum];
	phonBook tmp;
	system("cls");
	if(index>=maxNum){
		cout<<"you couldn't add any more!!! there is no free space\n";
		getch();
		return;
	}
	if(index!=0)
		for(int i=0;i<index;i++)
			pbTemp[i]=pb[i];	
	cout<<">>> Enter Information of your contact. Free Spaces: "<<(maxNum-index)<<"\n";	
	cout<<"===============================================================================\n";	
	cout<<"		Enter the Name Of PhoneContact "<<index+1<<" : ";
	cin>>tmp.name;
	cout<<"		Enter the Family Of PhoneContact "<<index+1<<" : ";
	cin>>tmp.family;
	cout<<"		Enter the Number Of PhoneContact "<<index+1<<" : ";
	cin>>tmp.telNum;	
	cout<<"---------------------------------------------------------------------\n";
	pbTemp[index]=tmp;		
	index++;
	pb=pbTemp;
	cout<<"	Your Contact Saved successfully.\n";
	cout<<"---------------------------------------------------------------------\n";	
	getch();	
	ofstream file;
	file.open("phon.txt");
	for(int i=0;i<index;i++)
		file<<pb[i].name<<" "<<pb[i].family<<" "<<pb[i].telNum<<endl;
	file.close();
}
void showAllArrayInfo(){
	system("cls");	
	cout<<" Showing Contact information: \n";
	cout<<"===============================================================================\n";
	for(int i=0;i<index;i++){
		cout<<"-> contact "<<i+1<<" : "<<pb[i].name<<"    "<<pb[i].family<<"    "<<pb[i].telNum<<"\n";		
		if(i!=index-1) cout<<"-----------------------------------------------------------------------------\n";
	}
	cout<<"===============================================================================\n";	
	getch();
}
void showAllFileInfo(){
	system("cls");	
	phonBook tmp;
	ifstream file;
	int i=1;
	file.open("phon.txt");		
	cout<<" Showing Contact information: \n";
	cout<<"===============================================================================\n";
	while(!file.eof()){
		file>>tmp.name;
		file>>tmp.family;
		file>>tmp.telNum;	
		cout<<"-> contact "<<i<<" : "<<tmp.name<<"    "<<tmp.family<<"    "<<tmp.telNum<<"\n";		
		cout<<"-----------------------------------------------------------------------------\n";
		i++;
	}
	cout<<"===============================================================================\n";	

	getch();
	file.close();
}
void showAllInfo(){
	while(true){
		system("cls");
		if(index==0){
			cout<<"===============================================================================\n";
			cout<<" there is No Added Contact to show! Select Add Contact and continue.\n";
			cout<<"===============================================================================\n";
			getch();
			return;
		}
		int sel;
		cout<<"Which Contact do you want to show?	1.Array		2.File		3.back\n";
		cout<<"-> ";
		cin>>sel;
		switch(sel){
		case 1:	showAllArrayInfo(); return;
		case 2: showAllFileInfo(); return;
		case 3: return;
		default: cout<<"incorrect select. try again.\n"; getch();
		}
	}
}
void sortByTelno(){
	for(int i=0;i<index;i++)
		for(int j=i+1;j<index;j++){
			string s=pb[i].telNum;
			string s2=pb[j].telNum;
			if(s.compare(s2)==1){
				phonBook tmp=pb[i];
				pb[i]=pb[j];
				pb[j]=tmp;
			}
		}
	system("cls");
	cout<<"===============================================================================\n";
	cout<<" your contacts sorted by telNumbers successfully!!! \n";	
	cout<<"===============================================================================\n";
	getch();
}
void sortByFamily(){
	for(int i=0;i<index;i++)
		for(int j=i+1;j<index;j++){
			string s=pb[i].family;
			string s2=pb[j].family;
			if(s.compare(s2)==1){
				phonBook tmp=pb[i];
				pb[i]=pb[j];
				pb[j]=tmp;
			}
		}
	system("cls");
	cout<<"===============================================================================\n";
	cout<<" your contacts sorted by Family successfully!!! \n";	
	cout<<"===============================================================================\n";
	getch();
}
void sortArray(){
	while(true){
		system("cls");
		if(index<=1){
			cout<<"===============================================================================\n";
			cout<<" there is No Contacts more than 2 ones to sorting!\n";
			cout<<"===============================================================================\n";
			getch();
			return;
		}
		int sel;
		cout<<"which one do you want to use to sort? 1.TelNumber	2.Family	3.back\n";
		cout<<"-> ";
		cin>>sel;
		switch(sel){
		case 1:	sortByTelno(); return;
		case 2: sortByFamily(); return;
		case 3: return;
		default: cout<<"incorrect select. try again.\n"; getch();
		}
	}
}
void searchByTelno(){
	system("cls");
	char teltmp[11];
	bool found=false;
	cout<<"Enter the TelNumber: ";
	cin>>teltmp;
	system("cls");
	for(int i=0;i<index;i++){
		string s=teltmp;
		string s2=pb[i].telNum;
		if(s.compare(s2)==0){
			found=true;			
			cout<<"Found Contact info is: \n";
			cout<<"		Name: "<<pb[i].name<<endl;
			cout<<"		Family: "<<pb[i].family<<endl;
			cout<<"		Tel Number: "<<pb[i].telNum<<endl;
			cout<<"-----------------------------------------------------------------\n";			
		}
	}
	if(!found){		
		cout<<"No Info Available!";		
	}
	getch();
}
void searchByFamily(){
	system("cls");
	char family[20];
	bool found=false;
	cout<<"Enter the Family: ";
	cin>>family;
	system("cls");
	for(int i=0;i<index;i++){
		string s=family;
		string s2=pb[i].family;
		if(s.compare(s2)==0){
			found=true;			
			cout<<"Found Contact info is: \n";
			cout<<"		Name: "<<pb[i].name<<endl;
			cout<<"		Family: "<<pb[i].family<<endl;
			cout<<"		Tel Number: "<<pb[i].telNum<<endl;
			cout<<"-----------------------------------------------------------------\n";			
		}
	}
	if(!found){		
		cout<<"No Info Available!";		
	}
	getch();
}
void searchContact(){
	while(true){
		system("cls");
		if(index==0){
			cout<<"===============================================================================\n";
			cout<<" there is No Contacts to Search\n";
			cout<<"===============================================================================\n";
			getch();
			return;
		}
		int sel;
		cout<<"which one do you want to use to Search? 1.TelNumber	2.Family	3.back\n";
		cout<<"-> ";
		cin>>sel;
		switch(sel){
		case 1:	searchByTelno(); return;
		case 2: searchByFamily(); return;
		case 3: return;
		default: cout<<"incorrect select. try again.\n"; getch();
		}
	}
}
void editContact(){
	system("cls");
	if(index==0){
			cout<<"===============================================================================\n";
			cout<<" there is No Contacts to Edit\n";
			cout<<"===============================================================================\n";
			getch();
			return;
	}
	char name[20];
	bool found=false;
	cout<<"Enter the Name of The Contact to Editing Info: ";
	cin>>name;
	system("cls");
	for(int i=0;i<index;i++){
		string s=name;
		string s2=pb[i].name;
		if(s.compare(s2)==0){
			found=true;			
			cout<<"Found Contact info is: \n";
			cout<<"		Name: "<<pb[i].name<<endl;
			cout<<"		Family: "<<pb[i].family<<endl;
			cout<<"		Tel Number: "<<pb[i].telNum<<endl;
			cout<<"-----------------------------------------------------------------\n";						
			cout<<"Enter new Info: \n";
			cout<<"		Name: ";
			cin>>pb[i].name;
			cout<<"		Family: ";
			cin>>pb[i].family;
			cout<<"		Tel Number: ";
			cin>>pb[i].telNum;			
			cout<<"===============================================================================\n";
			cout<<" the Changes done! \n";	
			cout<<"===============================================================================\n";
		}
	}
	if(!found){		
		cout<<"No Info Available to Editing!";		
	}
	getch();
}
void clearRep(){
	system("cls");
	if(index<=1){
			cout<<"===============================================================================\n";
			cout<<" there is No Contacts More than 2 ones to Clear\n";
			cout<<"===============================================================================\n";
			getch();
			return;
	}
	for(int i=0;i<index;i++)
		for(int j=i+1;j<index;j++){
			string iname=pb[i].name;
			string jname=pb[j].name;
			string ifamily=pb[i].family;
			string jfamily=pb[j].family;
			string itel=pb[i].telNum;
			string jtel=pb[j].telNum;
			if(iname.compare(jname)==0 && ifamily.compare(jfamily)==0 && itel.compare(jtel)==0){				
				for(int k=j;k<index-1;k++)
					pb[k]=pb[k+1];
				index--;
				cout<<"===============================================================================\n";
				cout<<" Repitive Contact Cleared\n";
				cout<<"===============================================================================\n";
				continue;
			}
		}
		getch();
}
void exiting(){
	while(true){
		system("cls");
		int sel;
		cout<<"Are you sure to exit? 1.yes	2.no\n";
		cout<<"-> ";
		cin>>sel;
		switch(sel){
		case 1:	exit(0); break;
		case 2: return; break;
		default: cout<<"incorrect select. try again.\n"; getch();
		}
	}
}

void showMenu(){
	int selection;
	system("cls");
	cout<<"Select a Menu Item: \n";
	cout<<"		1. Add Contact\n";
	cout<<"		2. Sort Contact Array\n";
	cout<<"		3. Show All contact\n";
	cout<<"		4. Search contact\n";
	cout<<"		5. Edit contact\n";
	cout<<"		6. Clear Repetitives\n";
	cout<<"		7. Exit\n";
	cout<<"-> ";
	cin>>selection;
	switch(selection){
		case 1: addInfo();break;
		case 2: sortArray();break;
		case 3: showAllInfo();break;
		case 4: searchContact();break;
		case 5: editContact();break;
		case 6: clearRep();break;
		case 7: exiting();break;
		default: cout<<" Incorrect Selecting. try Again!\n";getch();
		}	
}
int main()
{	
	infoNum();	
	while(true){		
		showMenu();				
	}
	return 0;
}
