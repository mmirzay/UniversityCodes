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
    public partial class RoomToStudent : Form
    {
        string[][] stus;
        string[][] rooms;
        string[][] mem;
        Student s = new Student();
        Room r = new Room();
        RoomsMembers rm = new RoomsMembers();
        int roomCap = 0;
        bool notIsEmpty = false;
        bool hasPlace = false;
        string sKind = "";
        string roomKind = "";
        bool nonS = false;
        public RoomToStudent()
        {
            InitializeComponent();
        }

        private void RoomToStudent_Load(object sender, EventArgs e)
        {            
            stus = s.loadStudent();
            for(int i=0;i<stus.Length;i++)
                this.cmbStuID.Items.Add(stus[i][13]);            
            rooms = r.loadRooms();
            for (int i = 0; i < rooms.Length; i++)
                this.cmbRoomNum.Items.Add(rooms[i][0]);
            cmbRoomNum.Enabled = false;
        }
        private void btnEnseraf_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void cmbStuID_SelectedIndexChanged(object sender, EventArgs e)
        {
            cmbRoomNum.Enabled = true;
            hasPlace = false;
            for(int i=0;i<stus.Length;i++)
                if(stus[i][13].Equals(this.cmbStuID.Text)){
                    txtName.Text=stus[i][0]+" "+stus[i][1];
                    txtField.Text=stus[i][8];txtFName.Text=stus[i][2];
                    txtNum.Text = stus[i][3];
                    if(stus[i][4].Equals("مرد"))
                        sKind="پسر";
                    else
                        sKind="دختر";
                    mem = rm.loadMembers();
                    for(int j=0;j<mem.Length;j++)
                        if (mem[j][0].Equals(cmbStuID.Text))
                        {                            
                            hasPlace = true;
                            break;
                        }
                    break;
                }
        }

        private void cmbRoomNum_SelectedIndexChanged(object sender, EventArgs e)
        {
            roomCap=0;
            notIsEmpty = false;
            for(int i=0;i<rooms.Length;i++)
                if (rooms[i][0].Equals(cmbRoomNum.Text))
                {
                    txtRoomCap.Text = rooms[i][1];
                    txtRoomType.Text = rooms[i][2];
                    txtRoomS.Text = rooms[i][3];
                    mem = rm.loadMembers();
                    for (int j = 0; j < mem.Length; j++)
                        if (mem[j][1].Equals(cmbRoomNum.Text))
                            roomCap++;
                    txtTedad.Text = ""+roomCap;
                    if(txtTedad.Text.Equals(txtRoomCap.Text))
                        notIsEmpty=true;
                    roomKind = txtRoomS.Text;
                    break;
                }
        }

        private void btnTahwil_Click(object sender, EventArgs e)
        {
            if (cmbStuID.Text == "" || cmbRoomNum.Text == "")
                MessageBox.Show(".اطلاعات را کامل وارد کنید", "اخطار", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {                
                if(notIsEmpty)
                    MessageBox.Show(".ظرفیت اتاق تکمیل است", "اخطار", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if (hasPlace)
                    MessageBox.Show(".این دانشجو دارای اتاق می باشد", "اخطار", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if(!sKind.Equals(roomKind))
                    MessageBox.Show(" این اتاق مختص دانشجویان " + roomKind + " می باشد", "اخطار", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else
                {
                    rm._memID = cmbStuID.Text;
                    rm._roomNum = cmbRoomNum.Text;
                    rm.saveMember();
                    MessageBox.Show(".اطلاعات ذخیره شد", "ذخیره سازی", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    this.Close();
                }
            }
        }

    }
}
