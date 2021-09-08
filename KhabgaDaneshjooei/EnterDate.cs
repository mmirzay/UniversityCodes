using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace KhabgaDaneshjooei
{
    class EnterDate
    {
        public string _idNum { get; set; }
        public string _day { get; set; }
        public string _month { get; set; }
        public string _year { get; set; }
        public string _hour { get; set; }
        public string _min { get; set; }
        public void saveDate()
        {
            File.AppendAllText("EnterDate.txt",_idNum+"%"+_day+"%"+_month+"%"+_year+"%"+_hour+"%"+_min+"#");
        }
        public string[][] loadDate()
        {
            string allDate = File.ReadAllText("EnterDate.txt");
            char[] ch = allDate.ToCharArray();
            int dateCounter = 0;
            for (int i = 0; i < ch.Length; i++)
                if (ch[i].Equals('#'))
                    dateCounter++;
            string[][] d = new string[dateCounter][];
            for (int i = 0; i < d.Length; i++)
                d[i] = new string[6];
            for (int i = 0; i < d.Length; i++)
                for (int j = 0; j < 6; j++)
                    d[i][j] = "";
            string tmp = "";
            dateCounter = 0;
            for (int i = 0; i < ch.Length; i++)
            {
                if (ch[i].Equals('%'))
                {
                    if (d[dateCounter][0].Equals(""))
                        d[dateCounter][0] = tmp;
                    else if (d[dateCounter][1].Equals(""))
                        d[dateCounter][1] = tmp;
                    else if (d[dateCounter][2].Equals(""))
                        d[dateCounter][2] = tmp;
                    else if (d[dateCounter][3].Equals(""))
                        d[dateCounter][3] = tmp;
                    else if (d[dateCounter][4].Equals(""))
                        d[dateCounter][4] = tmp;
                    tmp = "";
                    continue;
                }
                else if (ch[i].Equals('#'))
                {
                    d[dateCounter][5] = tmp;
                    tmp = "";
                    dateCounter++;
                    continue;
                }
                tmp = tmp + ch[i];
            }
            return d;            
        }
    }
}
