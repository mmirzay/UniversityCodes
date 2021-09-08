using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace KhabgaDaneshjooei
{
    class RoomsMembers
    {
        public string _memID { get; set; }
        public string _roomNum { get; set; }
        public int _MembersCounter { get; set; }
        public void saveMember()
        {
            File.AppendAllText("RoomsMember.txt", _memID + "%" + _roomNum + "#");
        }
        public string[][] loadMembers()
        {
            string allMem = File.ReadAllText("RoomsMember.txt");
            char[] ch = allMem.ToCharArray();
            int membersCounter = 0;
            for(int i=0;i<ch.Length;i++)
                if(ch[i].Equals('#'))
                    membersCounter++;
            _MembersCounter = membersCounter;
            string[][] members=new string[membersCounter][];
            for(int i=0;i<members.Length;i++)
                members[i]=new string[2];
            for (int i = 0; i < members.Length; i++)
                for (int j = 0; j < 2; j++)
                    members[i][j] = "";
            string tmp="";
            membersCounter=0;
            for (int i = 0; i < ch.Length; i++)
            {
                if (ch[i].Equals('%'))
                {                    
                    members[membersCounter][0]=tmp;
                    tmp = "";
                    continue;
                }
                else if (ch[i].Equals('#'))
                {
                    members[membersCounter][1] = tmp;
                    tmp = "";
                    membersCounter++;
                    continue;
                }
                tmp = tmp + ch[i];
            }
            return members;
        }
    }
}
