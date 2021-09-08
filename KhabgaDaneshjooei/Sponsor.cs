using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace KhabgaDaneshjooei
{
    class Sponsor
    {
        public string _IDNum { get; set; }
        public string _SprName { get; set; }
        public string _SprFamily { get; set; }
        public string _SprNum { get; set; }
        public void saveSponsor()
        {
            File.AppendAllText("Sponsors.txt", _IDNum + "%" + _SprName + "%" + _SprFamily + "%" + _SprNum + "#");
        }
        public string[][] loadSponsors()
        {
            string allspr = File.ReadAllText("Sponsors.txt");
            char[] ch = allspr.ToCharArray();
            int sprCounter = 0;
            for (int i = 0; i < ch.Length; i++)
                if (ch[i].Equals('#'))
                    sprCounter++;
            string[][] sprs = new string[sprCounter][];
            for (int i = 0; i < sprs.Length; i++)
                sprs[i] = new string[4];
            for (int i = 0; i < sprs.Length; i++)
                for (int j = 0; j < 4; j++)
                    sprs[i][j] = "";
            string tmp = "";
            sprCounter = 0;
            for (int i = 0; i < ch.Length; i++)
            {
                if (ch[i].Equals('%'))
                {
                    if (sprs[sprCounter][0].Equals(""))
                        sprs[sprCounter][0] = tmp;
                    else if (sprs[sprCounter][1].Equals(""))
                        sprs[sprCounter][1] = tmp;
                    else if (sprs[sprCounter][2].Equals(""))
                        sprs[sprCounter][2] = tmp;
                    tmp = "";
                    continue;
                }
                else if (ch[i].Equals('#'))
                {
                    sprs[sprCounter][3] = tmp;
                    tmp = "";
                    sprCounter++;
                    continue;
                }
                tmp = tmp + ch[i];
            }
            return sprs;
        }
    }
}
