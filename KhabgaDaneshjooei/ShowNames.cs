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
    public partial class ShowNames : Form
    {
        string[][] stus;
        string[][] mem;
        Student s = new Student();
        RoomsMembers rm = new RoomsMembers();
        string room = "";
        public ShowNames()
        {
            InitializeComponent();
        }

        private void ShowNames_Load(object sender, EventArgs e)
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("نام");
            dt.Columns.Add("نام خانوادگی");
            dt.Columns.Add("نام پدر");
            dt.Columns.Add("شماره شناسنامه");
            dt.Columns.Add("رشته");
            dt.Columns.Add("شماره دانشجویی");
            dt.Columns.Add("شماره اتاق");
            //////////////////////////////
            stus = s.loadStudent();
            mem = rm.loadMembers();
            for (int i = 0; i < stus.Length; i++)
            {
                room = "اتاق ندارد";
                for(int j=0;j<mem.Length;j++)
                    if(mem[j][0].Equals(stus[i][13]))
                        room=mem[j][1];
                dt.Rows.Add(stus[i][0],stus[i][1],stus[i][2],
                    stus[i][3],stus[i][8],stus[i][13],room);
            }
            dtg.DataSource = dt;
        }

        private void btnEnseraf_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void dtg_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}
