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
    public partial class CourseDeleting : Form
    {
        public CourseDeleting()
        {
            InitializeComponent();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void CourseDeleting_Load(object sender, EventArgs e)
        {
            this.SetBounds(20, 30, this.Width, this.Height);
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

        private void cmbCrsCode_SelectedIndexChanged(object sender, EventArgs e)
        {
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select * from course";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                if (cmbCrsCode.Text.Equals("" + sqldr["کد"]))
                {
                    rtxtCrsCaption.Text = "" + sqldr["عنوان"];
                    rtxtCrsUnit.Text = "" + sqldr["تعداد واحد"];
                    rtxtCrsGroup.Text = "" + sqldr["گروه"];
                    rtxtCrsStuType.Text = "" + sqldr["نوع دانشجو"];
                    rtxtCrsRef.Text = "" + sqldr["مراجع"];
                    rtxtCrsStuCount.Text = "" + sqldr["تعداد دانشجو"];
                    rtxtCrsMasterName.Text = "" + sqldr["مدرس"];
                    rtxtCrsMasterCode.Text = "" + sqldr["کد مدرس"];                    
                    break;
                }
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void btnDel_Click(object sender, EventArgs e)
        {
            if (cmbCrsCode.Text.Equals(""))
                MessageBox.Show("کد درس را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {
                DialogResult res = MessageBox.Show("آیا مطمئن هستید؟ سوالاتی را که برای این درس ثبت کرده اید نیز حذف خواهند شد", "حذف", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                if (res == DialogResult.Yes)
                {
                    string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
                    SqlConnection sqlcnn = new SqlConnection(strcnn);
                    SqlCommand sqlcmd = new SqlCommand();
                    sqlcmd.Connection = sqlcnn;
                    sqlcmd.CommandText = "delete from Course where کد='"+cmbCrsCode.Text+"'";
                    sqlcnn.Open();
                    try
                    {
                        sqlcmd.ExecuteNonQuery();
                        sqlcmd.CommandText = "delete from Q2 where [کد درس]='" + cmbCrsCode.Text + "'";
                        sqlcmd.ExecuteNonQuery();
                        sqlcmd.CommandText = "delete from Q4 where [کد درس]='" + cmbCrsCode.Text + "'";
                        sqlcmd.ExecuteNonQuery();
                        sqlcmd.CommandText = "delete from Examination where [کد درس]='" + cmbCrsCode.Text + "'";
                        sqlcmd.ExecuteNonQuery();
                        sqlcnn.Close();
                        sqlcnn.Dispose();
                        sqlcmd.Dispose();
                        MessageBox.Show("این درس حذف گردید", "حذف", MessageBoxButtons.OK, MessageBoxIcon.Information);
                        this.Close();
                    }
                    catch (SqlException sqlex)
                    {                        
                            MessageBox.Show(" خطا در مقادیر", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }//if yes
            }
        }
    }
}
