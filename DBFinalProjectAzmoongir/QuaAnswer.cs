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
    public partial class QuaAnswer : Form
    {
        public QuaAnswer()
        {
            InitializeComponent();
        }
        string crsCode = "";
        int q4Counter = 0, counter = 1;
        private void QuaAnswer_Load(object sender, EventArgs e)
        {
            this.SetBounds(20, 30, this.Width, this.Height);
            grbCover.Hide();
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select کد from course";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                cmbCrsCode.Items.Add(sqldr["کد"]);
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnContinue_Click(object sender, EventArgs e)
        {
            if (btnContinue.Text.Equals("ادامه"))
            {
                if (cmbCrsCode.Text.Equals(""))
                    MessageBox.Show("همه ی مقادیر را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else
                {
                    crsCode = cmbCrsCode.Text;
                    q4Counter = int.Parse(dudQ2Counter.Text);
                    btnContinue.Text = "ثبت سوال";
                    this.FormBorderStyle = FormBorderStyle.None;
                    grbCover.Show();
                    btnCancel.Hide();
                }
            }
            else
            {
                if (txtQ4Num.Text.Equals("") || txtQ4Caption.Text.Equals("")
                    || txtQ4opt1.Text.Equals("") || txtQ4opt2.Text.Equals("")
                    ||txtQ4opt3.Text.Equals("")|| txtQ4opt4.Text.Equals("")
                    || cmbAnswer.Text.Equals(""))
                    MessageBox.Show("همه ی مقادیر را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else
                {
                    string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
                    SqlConnection sqlcnn = new SqlConnection(strcnn);
                    SqlCommand sqlcmd = new SqlCommand();
                    sqlcmd.Connection = sqlcnn;
                    sqlcmd.CommandText = "insert into Q4 values('" + txtQ4Num.Text + "','" + txtQ4Caption.Text + "','" +
                    txtQ4opt1.Text + "','" + txtQ4opt2.Text + "','" 
                    + txtQ4opt3.Text + "','" + txtQ4opt4.Text + "','" 
                    + cmbAnswer.Text + "','" + crsCode + "')";
                    sqlcnn.Open();
                    try
                    {
                        sqlcmd.ExecuteNonQuery();
                        sqlcnn.Close();
                        sqlcnn.Dispose();
                        sqlcmd.Dispose();
                        counter++;
                        if (counter <= q4Counter)
                        {
                            MessageBox.Show(" این سوال ثبت شد. لطفا سوال بعدی را وارد کنید ", "سوال", MessageBoxButtons.OK, MessageBoxIcon.Information);
                            txtQ4Num.Text = ""; txtQ4Caption.Text = ""; txtQ4opt1.Text = ""; txtQ4opt2.Text = "";
                            txtQ4opt3.Text = ""; txtQ4opt4.Text = "";
                        }
                        else
                        {
                            this.Close();
                        }
                    }
                    catch (SqlException sqlex)
                    {
                        if (sqlex.ErrorCode == -2146232060)
                            MessageBox.Show("شماره سوال قبلا وارد شده است.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        else
                            MessageBox.Show(" خطا در وارد کردن مقادیر", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }
            }//else
        }

        private void cmbCrsCode_SelectedIndexChanged(object sender, EventArgs e)
        {
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select کد, عنوان, مدرس from course";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                if (cmbCrsCode.Text.Equals("" + sqldr["کد"]))
                {
                    txtCrsCaption.Text = "" + sqldr["عنوان"];
                    txtCrsMasterName.Text = "" + sqldr["مدرس"];
                }
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }
            

    }
}
