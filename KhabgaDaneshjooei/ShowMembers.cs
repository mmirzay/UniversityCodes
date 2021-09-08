using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace KhabgaDaneshjooei
{
    public partial class ShowMembers : Form
    {
        string[][] stus;
        string[][] rooms;
        string[][] mem;
        Student s = new Student();
        Room r = new Room();
        RoomsMembers rm = new RoomsMembers();
        int roomCap = 0;                
        DataTable dt = new DataTable();
        public ShowMembers()
        {
            InitializeComponent();
        }

        private void btnEnseraf_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void ShowMembers_Load(object sender, EventArgs e)
        {
            rooms = r.loadRooms();
            stus = s.loadStudent();            
            dt.Columns.Add("نام");
            dt.Columns.Add("نام خانوادگی");
            dt.Columns.Add("نام پدر");
            dt.Columns.Add("شماره شناسنامه");
            dt.Columns.Add("رشته");
            dt.Columns.Add("شماره دانشجویی");
            for (int i = 0; i < rooms.Length; i++)
                this.cmbRoomNum.Items.Add(rooms[i][0]);            
            dtg.DataSource = dt;
        }

        private void cmbRoomNum_SelectedIndexChanged(object sender, EventArgs e)
        {
            dt.Clear();
            dtg.DataSource = dt;
            roomCap = 0;
            for (int i = 0; i < rooms.Length; i++)
                if (rooms[i][0].Equals(cmbRoomNum.Text))
                {
                    txtRoomCap.Text = rooms[i][1];
                    txtRoomType.Text = rooms[i][2];
                    txtRoomS.Text = rooms[i][3];
                    mem = rm.loadMembers();                                        
                    for (int j = 0; j < mem.Length; j++)
                        if (mem[j][1].Equals(cmbRoomNum.Text))
                        {
                            for(int k=0;k<stus.Length;k++)
                                if(mem[j][0].Equals(stus[k][13]))
                                    dt.Rows.Add(stus[k][0], stus[k][1], stus[k][2],
                                    stus[k][3], stus[k][8], stus[k][13]);
                            roomCap++;
                        }
                    txtTedad.Text = "" + roomCap;
                    break;
                }
            dtg.DataSource = dt;
        }
    }
}
