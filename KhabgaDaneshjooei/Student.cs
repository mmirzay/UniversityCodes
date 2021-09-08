using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace KhabgaDaneshjooei
{
    class Student
    {
        public string  _Name { get; set; }
        public string _Family { get; set; }
        public string _FName { get; set; }
        public string _Num { get; set; }
        public string _S{ get; set; }
        public string _Tel { get; set; }
        public string _Address { get; set; }
        public string _Daneshkade { get; set; }
        public string _Field { get; set; }
        public string _Maghta { get; set; }
        public string _Dore { get; set; }
        public string _Nimsal { get; set; }
        public string _Sal { get; set; }
        public string _StuID { get; set; }
        public int _StudentsCounter { get; set; }
        public void saveStudent()
        {
            File.AppendAllText("Students.txt", _Name+"%"+_Family+"%"+
                _FName+"%"+_Num+"%"+_S+"%"+_Tel+"%"+_Address+"%"+_Daneshkade+"%"+_Field+"%"+
                _Maghta+"%"+_Dore+"%"+_Nimsal+"%"+_Sal+"%"+_StuID+"#\n");
        }
        public void studentsCounter()
        {
            string allNames = File.ReadAllText("Students.txt");
            char[] ch = allNames.ToCharArray();
            int studentCounter = 0;
            for (int i = 0; i < ch.Length; i++)
                if (ch[i].Equals('#'))
                    studentCounter++;
            _StudentsCounter = studentCounter;            
        }
        public string[][] loadStudent()
        {
            string allNames = File.ReadAllText("Students.txt");
            char[] ch=allNames.ToCharArray();
            int studentCounter = 0;
            for(int i=0;i<ch.Length;i++)
                if(ch[i].Equals('#'))
                    studentCounter++;
            _StudentsCounter = studentCounter;            
            string[][] stus=new string[studentCounter][];
            for (int i = 0; i < stus.Length; i++)                
                    stus[i] = new string[14];
            for (int i = 0; i < stus.Length; i++)
                for (int j = 0; j < 14; j++)
                    stus[i][j] = "";            
            string tmp = "";
            studentCounter = 0;
            for (int j = 0; j < ch.Length; j++)
            {
                if (ch[j].Equals('%'))
                {
                    if (stus[studentCounter][0].Equals(""))
                        stus[studentCounter][0] = tmp;
                    else if (stus[studentCounter][1].Equals(""))
                        stus[studentCounter][1] = tmp;
                    else if (stus[studentCounter][2].Equals(""))
                        stus[studentCounter][2] = tmp;
                    else if (stus[studentCounter][3].Equals(""))
                        stus[studentCounter][3] = tmp;
                    else if (stus[studentCounter][4].Equals(""))
                        stus[studentCounter][4] = tmp;
                    else if (stus[studentCounter][5].Equals(""))
                        stus[studentCounter][5] = tmp;
                    else if (stus[studentCounter][6].Equals(""))
                        stus[studentCounter][6] = tmp;
                    else if (stus[studentCounter][7].Equals(""))
                        stus[studentCounter][7] = tmp;
                    else if (stus[studentCounter][8].Equals(""))
                        stus[studentCounter][8] = tmp;
                    else if (stus[studentCounter][9].Equals(""))
                        stus[studentCounter][9] = tmp;
                    else if (stus[studentCounter][10].Equals(""))
                        stus[studentCounter][10] = tmp;
                    else if (stus[studentCounter][11].Equals(""))
                        stus[studentCounter][11] = tmp;
                    else if (stus[studentCounter][12].Equals(""))
                        stus[studentCounter][12] = tmp;
                    tmp = "";
                    continue;
                }
                else if (ch[j].Equals('#'))
                {
                    stus[studentCounter][13] = tmp;
                    tmp = "";
                    studentCounter++;
                    continue;
                }
                tmp = tmp + ch[j];
            }
            return stus;
        }
    }
}
