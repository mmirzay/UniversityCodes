using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace KhabgaDaneshjooei
{
    class Infraction
    {
        public string _IDNum { get; set; }
        public string _Inf { get; set; }
        public string _Com { get; set; }
        public void saveInfraction()
        {
            File.AppendAllText("Infractions.txt", _IDNum + "%" + _Inf + "%" + _Com + "#");
        }
        public string[][] loadInfraction()
        {
            string allInf = File.ReadAllText("Infractions.txt");
            char[] ch = allInf.ToCharArray();
            int infCounter = 0;
            for (int i = 0; i < ch.Length; i++)
                if (ch[i].Equals('#'))
                    infCounter++;
            string[][] infs = new string[infCounter][];
            for (int i = 0; i < infs.Length; i++)
                infs[i] = new string[3];
            for (int i = 0; i < infs.Length; i++)
                for (int j = 0; j < 3; j++)
                    infs[i][j] = "";
            string tmp = "";
            infCounter = 0;
            for (int i = 0; i < ch.Length; i++)
            {
                if (ch[i].Equals('%'))
                {
                    if (infs[infCounter][0].Equals(""))
                        infs[infCounter][0] = tmp;
                    else if (infs[infCounter][1].Equals(""))
                        infs[infCounter][1] = tmp;                    
                    tmp = "";
                    continue;
                }
                else if (ch[i].Equals('#'))
                {
                    infs[infCounter][2] = tmp;
                    tmp = "";
                    infCounter++;
                    continue;
                }
                tmp = tmp + ch[i];
            }
            return infs;
        }
    }
}
