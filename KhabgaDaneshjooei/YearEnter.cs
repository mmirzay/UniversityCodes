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
    public partial class YearEnter : Form
    {
        Student s = new Student();
        RoomsMembers rm = new RoomsMembers();
        EnterDate ed = new EnterDate();
        string[][] stus;
        string[][] mem;
        string[][] date;
        bool hasPlace = false;
        public YearEnter()
        {
            InitializeComponent();
        }

        private void btnEnseraf_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void YearEnter_Load(object sender, EventArgs e)
        {
            stus=s.loadStudent();
            for(int i=0;i<stus.Length;i++)
                cmbStuID.Items.Add(stus[i][13]);
            date = ed.loadDate();
        }

        private void cmbStuID_SelectedIndexChanged(object sender, EventArgs e)
        {
            hasPlace = false;
            for (int i = 0; i < stus.Length; i++)
                if (stus[i][13].Equals(this.cmbStuID.Text))
                {
                    txtName.Text = stus[i][0] + " " + stus[i][1];
                    txtField.Text = stus[i][8]; txtFName.Text = stus[i][2];
                    txtNum.Text = stus[i][3];                    
                    mem = rm.loadMembers();                    
                    for (int j = 0; j < mem.Length; j++)                    
                        if (mem[j][0].Equals(cmbStuID.Text))
                        {
                            hasPlace = true;
                            txtRoomNum.Text = mem[j][1];
                            break;
                        }
                    if (!hasPlace)
                        txtRoomNum.Text = "اتاق ندارد";
                    else
                    {
                        int tedad=0;
                        for (int j = 0; j < date.Length; j++)
                            if (date[j][0].Equals(cmbStuID.Text))
                                tedad++;
                        Console.WriteLine("tedad: " + tedad);
                        if (tedad % 2 == 0)
                        {
                            lblIn.Visible = false; lblOut.Visible = true;
                        }
                        else
                        {
                            lblIn.Visible = true; lblOut.Visible = false;
                        }
                    }
                    break;
                }
        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void btnTahwil_Click(object sender, EventArgs e)
        {
            if(cmbStuID.Text.Equals(""))
                MessageBox.Show(".اطلاعات را کامل وارد کنید", "اخطار", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else if(!hasPlace)
                MessageBox.Show(".اتاقی برای دانشجو ثبت نشده است", "اخطار", MessageBoxButtons.OK, MessageBoxIcon.Error);                        
            else
            {                
                ed._idNum = cmbStuID.Text;
                if (lblIn.Visible == false)
                {
                    if (txtInDay.Text.Equals("") || cmbInMonth.Text.Equals("") || txtInYear.Text.Equals("")
                        || txtInH.Text.Equals("") || txtInMin.Text.Equals(""))
                        MessageBox.Show(".اطلاعات را کامل وارد کنید", "اخطار", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    else
                    {
                        ed._day = txtInDay.Text; ed._month = cmbInMonth.Text;
                        ed._year = txtInYear.Text; ed._hour = txtInH.Text;
                        ed._min = txtInMin.Text;
                        ed.saveDate();
                        MessageBox.Show(".اطلاعات ذخیره شد", "ذخیره سازی", MessageBoxButtons.OK, MessageBoxIcon.Information);
                        this.Close();
                    }
                }
                else if (lblOut.Visible == false)
                {
                    if (txtOutDay.Text.Equals("") || cmbOutMonth.Text.Equals("") || txtOutYear.Equals("")
                        || txtOutH.Text.Equals("") || txtOutMin.Text.Equals(""))
                        MessageBox.Show(".اطلاعات را کامل وارد کنید", "اخطار", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    else
                    {
                        ed._day = txtOutDay.Text; ed._month = cmbOutMonth.Text;
                        ed._year = txtOutYear.Text; ed._hour = txtOutH.Text;
                        ed._min = txtOutMin.Text;
                        ed.saveDate();
                        MessageBox.Show(".اطلاعات ذخیره شد", "ذخیره سازی", MessageBoxButtons.OK, MessageBoxIcon.Information);
                        this.Close();
                    }
                }                
            }
        }        
    }
}
