using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace Azmoongir
{
    public partial class StuReg : Form
    {
        public StuReg()
        {
            InitializeComponent();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            txtStuName.Text = ""; txtStuFamily.Text = "";
            txtStuMajor.Text = ""; txtStuID.Text = "";
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            if (txtStuName.Text.Equals("") || txtStuFamily.Text.Equals("")
                || txtStuMajor.Text.Equals("") || txtStuID.Text.Equals("") ||
                cmbStuType.Text.Equals(""))
                MessageBox.Show("همه ی مقادیر را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {
                string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
                SqlConnection sqlcnn = new SqlConnection(strcnn);
                SqlCommand sqlcmd = new SqlCommand();
                sqlcmd.Connection = sqlcnn;
                sqlcmd.CommandText = "insert into student values('" + txtStuName.Text + "','" +
                    txtStuFamily.Text + "','" + txtStuMajor.Text + "','" + txtStuID.Text + "','" + cmbStuType.Text + "')";
                sqlcnn.Open();
                try
                {
                    sqlcmd.ExecuteNonQuery();
                    sqlcnn.Close();
                    sqlcnn.Dispose();
                    sqlcmd.Dispose();
                    this.Close();
                }
                catch (SqlException sqlex)
                {
                    if (sqlex.ErrorCode == -2146232060)
                        MessageBox.Show("شماره دانشجویی قبلا وارد شده است.","خطا",MessageBoxButtons.OK,MessageBoxIcon.Error);
                    else
                        MessageBox.Show(" خطا در وارد کردن مقادیر", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        private void StuReg_Load(object sender, EventArgs e)
        {
            this.SetBounds(20, 30, this.Width, this.Height);
        }
    }
}
