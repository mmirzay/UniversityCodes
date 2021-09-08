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
    public partial class Spr : Form
    {
        Student s = new Student();
        RoomsMembers rm = new RoomsMembers();
        string[][] stus;
        bool hasPlace = false;
        public Spr()
        {
            InitializeComponent();
        }

        private void Spr_Load(object sender, EventArgs e)
        {
            stus = s.loadStudent();
            for (int i = 0; i < stus.Length; i++)
                cmbStuID.Items.Add(stus[i][13]);
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
            if (cmbStuID.Text.Equals("") || txtsName.Text.Equals("") || txtsFamily.Text.Equals("") || txtsTel.Text.Equals(""))
                MessageBox.Show(".اطلاعات را کامل وارد کنید", "اخطار", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {
                Sponsor sp = new Sponsor();
                sp._IDNum = cmbStuID.Text; sp._SprName = txtsName.Text;
                sp._SprFamily = txtsFamily.Text; sp._SprNum = txtsTel.Text;
                sp.saveSponsor();
                MessageBox.Show(".اطلاعات ذخیره شد", "ذخیره سازی", MessageBoxButtons.OK, MessageBoxIcon.Information);
                this.Close();
            }
        }
    }
}
