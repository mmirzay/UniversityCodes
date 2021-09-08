using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace KhabgaDaneshjooei
{
    class Room
    {
        public string _RoomNum { get; set; }
        public string _RoomCap { get; set; }
        public string _RoomType { get; set; }
        public string _RoomS { get; set; }
        public int _RoomsCounter { get; set; }
        public void saveRoom()
        {
            File.AppendAllText("Rooms.txt", _RoomNum + "%" + _RoomCap + "%" + _RoomType + "%" + _RoomS + "#\n");            
        }
        public string[][] loadRooms()
        {
            string allRoom = File.ReadAllText("Rooms.txt");
            char[] ch = allRoom.ToCharArray();
            int roomsCounter=0;
            for (int i = 0; i < ch.Length; i++)
                if (ch[i].Equals('#'))
                    roomsCounter++;
            _RoomsCounter = roomsCounter;
            string[][] rooms = new string[roomsCounter][];
            for (int i = 0; i < rooms.Length; i++)
                rooms[i] = new string[4];
            for (int i = 0; i < rooms.Length; i++)
                for (int j = 0; j < 4; j++)
                    rooms[i][j] = "";
            string tmp = "";
            roomsCounter = 0;
            for (int i = 0; i < ch.Length; i++) 
            {
                if (ch[i].Equals('%')){
                    if (rooms[roomsCounter][0].Equals(""))
                        rooms[roomsCounter][0] = tmp;
                    else if (rooms[roomsCounter][1].Equals(""))
                        rooms[roomsCounter][1] = tmp;
                    else if (rooms[roomsCounter][2].Equals(""))
                        rooms[roomsCounter][2] = tmp;
                    tmp = "";
                    continue;
                }
                else if (ch[i].Equals('#'))
                {
                    rooms[roomsCounter][3] = tmp;
                    tmp = "";
                    roomsCounter++;
                    continue;
                }
                tmp = tmp + ch[i];
            }
            return rooms;
        }
    }
}
