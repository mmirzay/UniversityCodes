using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace KhabgaDaneshjooei
{
    class Appendix
    {
        public string _IDNum { get; set; }
        public string _App { get; set; }
        public string _Com { get; set; }
        public void saveAppendix()
        {
            File.AppendAllText("Appendix.txt", _IDNum + "%" + _App + "%" + _Com + "#");
        }
        public string[][] loadAppendix()
        {
            string allApp = File.ReadAllText("Appendix.txt");
            char[] ch = allApp.ToCharArray();
            int appCounter = 0;
            for (int i = 0; i < ch.Length; i++)
                if (ch[i].Equals('#'))
                    appCounter++;
            string[][] apps = new string[appCounter][];
            for (int i = 0; i < apps.Length; i++)
                apps[i] = new string[3];
            for (int i = 0; i < apps.Length; i++)
                for (int j = 0; j < 3; j++)
                    apps[i][j] = "";
            string tmp = "";
            appCounter = 0;
            for (int i = 0; i < ch.Length; i++)
            {
                if (ch[i].Equals('%'))
                {
                    if (apps[appCounter][0].Equals(""))
                        apps[appCounter][0] = tmp;
                    else if (apps[appCounter][1].Equals(""))
                        apps[appCounter][1] = tmp;
                    tmp = "";
                    continue;
                }
                else if (ch[i].Equals('#'))
                {
                    apps[appCounter][2] = tmp;
                    tmp = "";
                    appCounter++;
                    continue;
                }
                tmp = tmp + ch[i];
            }
            return apps;
        }
    }
}
