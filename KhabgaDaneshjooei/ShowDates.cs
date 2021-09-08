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
    public partial class ShowDates : Form
    {
        DataTable dt = new DataTable();
        string[][] stus;
        Student s = new Student();
        EnterDate ed = new EnterDate();
        string[][] dates;
        public ShowDates()
        {
            InitializeComponent();
        }

        private void ShowDates_Load(object sender, EventArgs e)
        {
            stus = s.loadStudent();
            for (int i = 0; i < stus.Length; i++)
                cmbStuID.Items.Add(stus[i][13]);
            dt.Columns.Add("ورود/خروج");
            dt.Columns.Add("ساعت");
            dt.Columns.Add("دقیقه");
            dt.Columns.Add("روز");
            dt.Columns.Add("ماه");
            dt.Columns.Add("سال");
            dtg.DataSource = dt;
        }

        private void cmbStuID_SelectedIndexChanged(object sender, EventArgs e)
        {
            dt.Clear();
            dtg.DataSource = dt;
            for (int i = 0; i < stus.Length; i++)
                if (stus[i][13].Equals(this.cmbStuID.Text))
                {
                    txtName.Text = stus[i][0] + " " + stus[i][1];
                    txtField.Text = stus[i][8]; txtFName.Text = stus[i][2];
                    txtNum.Text = stus[i][3];
                    dates = ed.loadDate();
                    int datesCounter=1;
                    string v="";
                    for(int j=0;j<dates.Length;j++)
                        if (dates[j][0].Equals(cmbStuID.Text))
                        {
                            datesCounter = (datesCounter + 1) % 2;
                            if (datesCounter == 0)
                                v = "ورود";
                            else
                                v = "خروج";
                            dt.Rows.Add(v, dates[j][4], dates[j][5], dates[j][1], dates[j][2], dates[j][3]);
                        }
                    break;
                }
            dtg.DataSource = dt;
        }
    }
}
