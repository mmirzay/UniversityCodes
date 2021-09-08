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
    public partial class App : Form
    {
        Student s = new Student();
        RoomsMembers rm = new RoomsMembers();
        string[][] stus;        
        bool hasPlace = false;
        public App()
        {
            InitializeComponent();
        }

        private void App_Load(object sender, EventArgs e)
        {
            stus = s.loadStudent();
            for (int i = 0; i < stus.Length; i++)
                cmbStuID.Items.Add(stus[i][13]);
        }

        private void btnEnseraf_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void cmbStuID_SelectedIndexChanged(object sender, EventArgs e)
        {            
            for (int i = 0; i < stus.Length; i++)
                if (stus[i][13].Equals(this.cmbStuID.Text))
                {
                    txtName.Text = stus[i][0] + " " + stus[i][1];
                    txtField.Text = stus[i][8]; txtFName.Text = stus[i][2];
                    txtNum.Text = stus[i][3];                    
                    break;
                }
        }

        private void btnTahwil_Click(object sender, EventArgs e)
        {
            if (cmbStuID.Text.Equals("") || rtxtApp.Text.Equals(""))
                MessageBox.Show(rtxtCom.Text, "اخطار", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {
                Appendix app = new Appendix();
                app._IDNum = cmbStuID.Text; app._App = rtxtApp.Text;
                app._Com = rtxtCom.Text;
                app.saveAppendix();
                MessageBox.Show(".اطلاعات ذخیره شد", "ذخیره سازی", MessageBoxButtons.OK, MessageBoxIcon.Information);
                this.Close();
            }
        }
    }
}
