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
    public partial class ExaminationEditing : Form
    {
        string qType = "";
        int qCount = 0;
        public ExaminationEditing()
        {
            InitializeComponent();
        }

        private void ExaminationEditing_Load(object sender, EventArgs e)
        {
            this.SetBounds(20, 30, this.Width, this.Height);
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select [کد آزمون] from Examination";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                if (!cmbExamCode.Items.Contains(sqldr["کد آزمون"]))
                    cmbExamCode.Items.Add(sqldr["کد آزمون"]);
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void cmbExamCode_SelectedIndexChanged(object sender, EventArgs e)
        {
            cmbExamMajor.Enabled = true;
            cmbExamMajor.Items.Clear();
            grbChange.Enabled = false;
            rtxtExamType.Text = "رشته را وارد کنید";
            rtxtCrsCode.Text = "رشته را وارد کنید";
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select * from Examination where [کد آزمون]='" + cmbExamCode.Text + "'";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                cmbExamMajor.Items.Add("" + sqldr["رشته"]);
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void cmbExamMajor_SelectedIndexChanged(object sender, EventArgs e)
        {
            grbChange.Enabled = true;
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select * from Examination where [کد آزمون]='" + cmbExamCode.Text + "' and رشته='" + cmbExamMajor.Text + "'";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
            {
                rtxtExamType.Text = "" + sqldr["نوع آزمون"];
                rtxtCrsCode.Text = "" + sqldr["کد درس"];
                if (rtxtExamType.Text.Equals("Q2")) rdbQ2.Enabled = true;
                else rdbQ4.Enabled = true;
                txtExamCode.Text = cmbExamCode.Text;
                txtExamMajor.Text = cmbExamMajor.Text;                
            }
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
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
                if (!cmbCrsCode.Items.Contains(sqldr["کد درس"]))
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

        private void btnSaveChange_Click(object sender, EventArgs e)
        {
            if ((rdbQ2.Enabled == false && rdbQ4.Enabled == false) ||
                cmbCrsCode.Text.Equals("") || txtExamCode.Text.Equals("")
                || txtExamMajor.Text.Equals(""))
                MessageBox.Show("همه ی مقادیر را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {
                string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
                SqlConnection sqlcnn = new SqlConnection(strcnn);
                SqlCommand sqlcmd = new SqlCommand();
                sqlcmd.Connection = sqlcnn;
                sqlcmd.CommandText = "update Examination set [نوع آزمون]='" + qType + "', [کد درس]='" + cmbCrsCode.Text + "'," +
                    "[کد آزمون]='" + txtExamCode.Text + "', رشته='" + txtExamMajor.Text + "'"+", [تعداد سوالات]='"+txtQCount.Text+"'"+
                    "where [کد آزمون]='"+cmbExamCode.Text+"' and رشته='"+cmbExamMajor.Text+"'";
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

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
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
            sqlcmd.CommandText = "select [کد درس] from " + qType;
            sqldr.Close();
            sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                if (cmbCrsCode.Text.Equals("" + sqldr["کد درس"]))
                    qCount++;
            txtQCount.Text = "" + qCount;
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }        
    }
}
