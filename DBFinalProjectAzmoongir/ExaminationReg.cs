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
    public partial class ExaminationReg : Form
    {
        string qType = "";
        int qCount = 0;
        public ExaminationReg()
        {
            InitializeComponent();
        }

        private void ExaminationReg_Load(object sender, EventArgs e)
        {
            this.SetBounds(20, 30, this.Width, this.Height);        
        }

        private void rdbQ2_CheckedChanged(object sender, EventArgs e)
        {
            cmbCrsCode.Items.Clear();
            qType = "Q2";
            txtCrsCaption.Text = "کد درس را انتخاب کنید"; txtCrsMasterName.Text = "کد درس را انتخاب کنید";
            txtQCount.Text = "کد درس را انتخاب کنید";    
            this.SetBounds(20, 30, this.Width, this.Height);
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select [کد درس] from Q2";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                if(!cmbCrsCode.Items.Contains(sqldr["کد درس"]))
                    cmbCrsCode.Items.Add(sqldr["کد درس"]);
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
            grbCourse.Enabled = true;
        }

        private void rdbQ4_CheckedChanged(object sender, EventArgs e)
        {
            cmbCrsCode.Items.Clear();
            qType = "Q4";
            txtCrsCaption.Text = "کد درس را انتخاب کنید"; txtCrsMasterName.Text = "کد درس را انتخاب کنید";
            txtQCount.Text = "کد درس را انتخاب کنید";
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
            grbCourse.Enabled = true;
        }

        private void cmbCrsCode_SelectedIndexChanged(object sender, EventArgs e)
        {
            qCount = 0;
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
            sqlcmd.CommandText = "select [کد درس] from "+qType;
            sqldr.Close();
            sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                if (cmbCrsCode.Text.Equals("" + sqldr["کد درس"]))
                    qCount++;
            txtQCount.Text = ""+qCount;
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            if ((rdbQ2.Enabled==false && rdbQ4.Enabled==false) ||
                cmbCrsCode.Text.Equals("") || txtExamCode.Text.Equals("") 
                || txtExamMajor.Text.Equals(""))
                MessageBox.Show("همه ی مقادیر را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {
                string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
                SqlConnection sqlcnn = new SqlConnection(strcnn);
                SqlCommand sqlcmd = new SqlCommand();
                sqlcmd.Connection = sqlcnn;
                sqlcmd.CommandText = "insert into Examination values ('" + qType + "','" + cmbCrsCode.Text + "','" +
                    txtExamCode.Text + "','" + txtExamMajor.Text + "','"+txtQCount.Text+"')";
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
                        MessageBox.Show("کد آزمون و رشته قبلا وارد شده است.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    else
                        MessageBox.Show(" خطا در وارد کردن مقادیر", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }//else
        }
    }
}
