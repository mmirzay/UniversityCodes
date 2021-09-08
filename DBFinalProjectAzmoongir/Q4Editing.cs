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
    public partial class Q4Editing : Form
    {
        public Q4Editing()
        {
            InitializeComponent();
        }

        private void Q4Editing_Load(object sender, EventArgs e)
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
                if(!cmbCrsCode.Items.Contains(sqldr["کد درس"]))
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
            grbChange.Enabled = false;
            rtxtQCaption.Text = "شماره سوال را وارد کنید";
            rtxtOpt1.Text = ""; rtxtOpt2.Text = ""; rtxtOpt3.Text = ""; rtxtOpt4.Text = ""; rtxtAnswer.Text = "";
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select * from q4 where [کد درس]='" + cmbCrsCode.Text+"'";
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
            grbChange.Enabled = true;            
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select * from q4 where [کد درس]='"+cmbCrsCode.Text+"' and شماره='"+cmbQNum.Text+"'";
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
                txtQNum.Text = cmbQNum.Text;
                txtQCaption.Text = rtxtQCaption.Text;                
                txtOpt1.Text = rtxtOpt1.Text;
                txtOpt2.Text = rtxtOpt2.Text;
                txtOpt3.Text = rtxtOpt3.Text;
                txtOpt4.Text = rtxtOpt4.Text;
                cmbAnswer.Text = rtxtAnswer.Text;
            }
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnSaveChange_Click(object sender, EventArgs e)
        {
            if (cmbCrsCode.Text.Equals("")||
                cmbQNum.Text.Equals("")|| txtQNum.Text.Equals("") || txtQCaption.Text.Equals("")
                    || txtOpt1.Text.Equals("") || txtOpt2.Text.Equals("")
                    || txtOpt3.Text.Equals("") || txtOpt4.Text.Equals("")
                    || cmbAnswer.Text.Equals(""))
                MessageBox.Show("همه ی مقادیر را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {
                string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
                SqlConnection sqlcnn = new SqlConnection(strcnn);
                SqlCommand sqlcmd = new SqlCommand();
                sqlcmd.Connection = sqlcnn;
                sqlcmd.CommandText ="update q4 set شماره='"+txtQNum.Text+"', صورت='"+txtQCaption.Text+"',"
                    +"[گزینه ی اول]='"+txtOpt1.Text+"',[گزینه ی دوم]='"+txtOpt2.Text+"',[گزینه ی سوم]='"+txtOpt3.Text+
                    "',[گزینه ی چهارم]='"+txtOpt4.Text+"',جواب='"+cmbAnswer.Text+
                    "' where [کد درس]='"+cmbCrsCode.Text+"' and شماره='"+cmbQNum.Text+"'";
                sqlcnn.Open();
                try
                {
                    sqlcmd.ExecuteNonQuery();
                    sqlcnn.Close();
                    sqlcnn.Dispose();
                    sqlcmd.Dispose();
                    MessageBox.Show("تغییرات اعمال گردید", "تغییرات", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    this.Close();
                }
                catch (SqlException sqlex)
                {
                    if (sqlex.ErrorCode == -2146232060)
                        MessageBox.Show("شماره سوال قبلا وارد شده است.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    else
                        MessageBox.Show(" خطا در وارد کردن مقادیر", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }// methode
    }
}
