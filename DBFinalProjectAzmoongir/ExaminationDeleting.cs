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
    public partial class ExaminationDeleting : Form
    {
        public ExaminationDeleting()
        {
            InitializeComponent();
        }

        private void ExaminationDeleting_Load(object sender, EventArgs e)
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
            }
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void btnDel_Click(object sender, EventArgs e)
        {
            if (cmbExamCode.Text.Equals("") || cmbExamMajor.Text.Equals(""))
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
                    sqlcmd.CommandText = "delete from Examination where [کد آزمون]='" + cmbExamCode.Text + "' and رشته='" + cmbExamMajor.Text + "'";
                    sqlcnn.Open();
                    try
                    {
                        sqlcmd.ExecuteNonQuery();
                        sqlcnn.Close();
                        sqlcnn.Dispose();
                        sqlcmd.Dispose();
                        MessageBox.Show("آزمون حذف شد", "حذف", MessageBoxButtons.OK, MessageBoxIcon.Information);
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
