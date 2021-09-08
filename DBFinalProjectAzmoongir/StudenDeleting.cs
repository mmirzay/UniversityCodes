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
    public partial class StudenDeleting : Form
    {
        public StudenDeleting()
        {
            InitializeComponent();
        }

        private void StudenDeleting_Load(object sender, EventArgs e)
        {
            this.SetBounds(20, 30, this.Width, this.Height);
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select [شماره دانشجویی] from Student";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                cmbStuID.Items.Add(sqldr["شماره دانشجویی"]);
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void cmbStuID_SelectedIndexChanged(object sender, EventArgs e)
        {
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select * from Student";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                if (cmbStuID.Text.Equals("" + sqldr["شماره دانشجویی"]))
                {
                    rtxtStuName.Text = "" + sqldr["نام"];
                    rtxtStuFamily.Text = "" + sqldr["نام خانوادگی"];
                    rtxtStuMajor.Text = "" + sqldr["رشته"];
                    rtxtStuType.Text = "" + sqldr["جنسیت"];                    
                    break;
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

        private void btnDel_Click(object sender, EventArgs e)
        {
            if (cmbStuID.Text.Equals(""))
                MessageBox.Show("شماره دانشجویی را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {
                DialogResult res = MessageBox.Show("آیا مطمئن هستید؟", "حذف", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                if (res == DialogResult.Yes)
                {
                    string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
                    SqlConnection sqlcnn = new SqlConnection(strcnn);
                    SqlCommand sqlcmd = new SqlCommand();
                    sqlcmd.Connection = sqlcnn;
                    sqlcmd.CommandText = "delete from Student where [شماره دانشجویی]='" + cmbStuID.Text + "'";
                    sqlcnn.Open();
                    try
                    {
                        sqlcmd.ExecuteNonQuery();                        
                        sqlcnn.Close();
                        sqlcnn.Dispose();
                        sqlcmd.Dispose();
                        MessageBox.Show("این دانشجو حذف گردید", "حذف", MessageBoxButtons.OK, MessageBoxIcon.Information);
                        this.Close();
                    }
                    catch (SqlException sqlex)
                    {
                        MessageBox.Show(" خطا در مقادیر", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }//if yes
            }//else
        }
    }
}
