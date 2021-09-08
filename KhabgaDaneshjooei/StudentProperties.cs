using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
namespace KhabgaDaneshjooei
{
    public partial class StudentProperties : Form
    {
        public StudentProperties()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged_1(object sender, EventArgs e)
        {

        }

        private void btnEnseraf_Click(object sender, EventArgs e)
        {            
            this.Close();
        }

        private void btnClear_Click(object sender, EventArgs e)
        {                        
            txtName.Clear(); txtFamily.Clear();
            txtField.Clear(); txtFName.Clear();
            txtNum.Clear(); txtSal.Clear();
            txtStuID.Clear(); txtTel.Clear();
            rtxtAddress.Clear();
            cmbDaneshkade.ResetText(); cmbDore.ResetText();
            cmbMaghta.ResetText(); cmbNimsal.ResetText();
            cmbS.ResetText();
        }

        private void btnSabt_Click(object sender, EventArgs e)
        {
            Student stu = new Student();
            stu._Name = txtName.Text; stu._Family = txtFamily.Text;
            stu._FName = txtFName.Text; stu._Num = txtNum.Text;
            stu._S = cmbS.Text; stu._Tel = txtTel.Text;
            stu._Address = rtxtAddress.Text;
            stu._Daneshkade = cmbDaneshkade.Text; stu._Field = txtField.Text;
            stu._Maghta = cmbMaghta.Text; stu._Dore = cmbDore.Text;
            stu._Nimsal = cmbNimsal.Text; stu._Sal = txtSal.Text;
            stu._StuID = txtStuID.Text;
            if (stu._Name.Equals("") || stu._Family.Equals("") || stu._FName.Equals("") ||
                stu._Num.Equals("") || stu._S.Equals("") || stu._Tel.Equals("") || stu._Address.Equals("")
                || stu._Daneshkade.Equals("") || stu._Field.Equals("") || stu._Maghta.Equals("") ||
                stu._Dore.Equals("") || stu._Nimsal.Equals("") || stu._Sal.Equals("") || stu._StuID.Equals(""))
            {
                MessageBox.Show(".اطلاعات را کامل وارد کنید", "اخطار", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                stu.saveStudent();
                MessageBox.Show(".اطلاعات ذخیره شد", "ذخیره سازی", MessageBoxButtons.OK, MessageBoxIcon.Information);
                this.Close();
            }
        }
    }
}
