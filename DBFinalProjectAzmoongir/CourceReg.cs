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
    public partial class CourceReg : Form
    {
        public CourceReg()
        {
            InitializeComponent();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            txtCourseCaption.Text = "";txtCourseCode.Text = "";
            txtGroupCode.Text = "";
            txtStuCount.Text = ""; txtCourseRefrence.Text = "";
            txtMasterName.Text = ""; txtMasterCode.Text = "";
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            if (txtCourseCaption.Text.Equals("") || txtCourseCode.Text.Equals("") ||
                cmbUnit.Text.Equals("") || txtGroupCode.Text.Equals("") || txtStuCount.Text.Equals("") ||
                cmbStuType.Text.Equals("") || txtCourseRefrence.Text.Equals("") ||
                    txtMasterName.Text.Equals("") || txtMasterCode.Text.Equals(""))
                MessageBox.Show("همه ی مقادیر را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {
                string strcnn = "server=.;DataBase=Az;Integrated Security=True";
                SqlConnection sqlcnn = new SqlConnection(strcnn);
                SqlCommand sqlcmd = new SqlCommand();
                sqlcmd.Connection = sqlcnn;
                sqlcmd.CommandText = "insert into Course values('" + txtCourseCaption.Text + "','" +
                    txtCourseCode.Text + "','" + cmbUnit.Text + "','" + txtGroupCode.Text + "','" + txtStuCount.Text + 
                    "','"+ cmbStuType.Text+ "','"+ txtCourseRefrence.Text+ "','" +txtMasterName.Text+"','"+txtMasterCode.Text+"')";
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
                        MessageBox.Show("کد درس قبلا وارد شده است.","خطا",MessageBoxButtons.OK,MessageBoxIcon.Error);
                    else
                        MessageBox.Show(" خطا در وارد کردن مقادیر", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }                
            }//else
        }

        private void CourceReg_Load(object sender, EventArgs e)
        {
            this.SetBounds(20, 30, this.Width, this.Height);
        }
    }
}
