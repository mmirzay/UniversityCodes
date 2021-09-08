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
    public partial class Q4Deleting : Form
    {
        public Q4Deleting()
        {
            InitializeComponent();
        }

        private void Q4Deleting_Load(object sender, EventArgs e)
        {
            this.SetBounds(20, 30, this.Width, this.Height);
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select [کد درس] from Q4";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                if (!cmbCrsCode.Items.Contains(sqldr["کد درس"]))
                    cmbCrsCode.Items.Add(sqldr["کد درس"]);
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void cmbCrsCode_SelectedIndexChanged(object sender, EventArgs e)
        {
            cmbQNum.Enabled = true;
            cmbQNum.Items.Clear();            
            rtxtQCaption.Text = "شماره سوال را وارد کنید";
            rtxtOpt1.Text = ""; rtxtOpt2.Text = ""; rtxtOpt3.Text = ""; rtxtOpt4.Text = ""; rtxtAnswer.Text = "";
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select * from q4 where [کد درس]='" + cmbCrsCode.Text + "'";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                cmbQNum.Items.Add("" + sqldr["شماره"]);
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void cmbQNum_SelectedIndexChanged(object sender, EventArgs e)
        {            
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select * from q4 where [کد درس]='" + cmbCrsCode.Text + "' and شماره='" + cmbQNum.Text + "'";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
            {
                rtxtQCaption.Text = "" + sqldr["صورت"];
                rtxtOpt1.Text = "" + sqldr["گزینه ی اول"];
                rtxtOpt2.Text = "" + sqldr["گزینه ی دوم"];
                rtxtOpt3.Text = "" + sqldr["گزینه ی سوم"];
                rtxtOpt4.Text = "" + sqldr["گزینه ی چهارم"];
                rtxtAnswer.Text = "" + sqldr["جواب"];                
            }
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void btnDel_Click(object sender, EventArgs e)
        {
            if (cmbCrsCode.Text.Equals("") || cmbQNum.Text.Equals(""))
                MessageBox.Show("مقادیر را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {
                DialogResult res = MessageBox.Show("آیا مطمئن هستید؟", "حذف", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                if (res == DialogResult.Yes)
                {
                    string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
                    SqlConnection sqlcnn = new SqlConnection(strcnn);
                    SqlCommand sqlcmd = new SqlCommand();
                    sqlcmd.Connection = sqlcnn;
                    sqlcmd.CommandText = "delete from q4 where [کد درس]='"+cmbCrsCode.Text+"' and شماره='"+cmbQNum.Text+"'";
                    sqlcnn.Open();
                    try
                    {
                        sqlcmd.ExecuteNonQuery();
                        sqlcnn.Close();
                        sqlcnn.Dispose();
                        sqlcmd.Dispose();
                        MessageBox.Show("سوال حذف شد", "حذف", MessageBoxButtons.OK, MessageBoxIcon.Information);
                        this.Close();
                    }
                    catch (SqlException sqlex)
                    {                        
                            MessageBox.Show(" خطا در وارد کردن مقادیر", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }//if yes
            }//else
        }
    }
}
