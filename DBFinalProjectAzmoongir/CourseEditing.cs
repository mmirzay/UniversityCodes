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
    public partial class CourseEditing : Form
    {
        public CourseEditing()
        {
            InitializeComponent();
        }

        private void CourseEditing_Load(object sender, EventArgs e)
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
                    txtCrsCaption.Text = "" + sqldr["عنوان"];
                    cmbCrsUnit.Text = "" + sqldr["تعداد واحد"];
                    txtCrsGroup.Text = "" + sqldr["گروه"];
                    cmbCrsStuType.Text = ""+sqldr["نوع دانشجو"] ;
                    txtCrsRef.Text = "" + sqldr["مراجع"];
                    txtCrsStuCount.Text = "" + sqldr["تعداد دانشجو"];
                    txtCrsMasterName.Text = "" + sqldr["مدرس"];
                    txtCrsMasterCode.Text = "" + sqldr["کد مدرس"];
                    grbChange.Enabled = true;
                    txtCrsCode.Text = cmbCrsCode.Text;
                    break;
                }
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void btnSaveChange_Click(object sender, EventArgs e)
        {
            if (cmbCrsCode.Text.Equals("")||
                txtCrsCaption.Text.Equals("") || txtCrsCode.Text.Equals("") ||
                cmbCrsUnit.Text.Equals("") || txtCrsGroup.Text.Equals("") || txtCrsStuCount.Text.Equals("") ||
                cmbCrsStuType.Text.Equals("") || txtCrsRef.Text.Equals("") ||
                    txtCrsMasterName.Text.Equals("") || txtCrsMasterCode.Text.Equals(""))
                MessageBox.Show("همه ی مقادیر را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {
                string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
                SqlConnection sqlcnn = new SqlConnection(strcnn);
                SqlCommand sqlcmd = new SqlCommand();
                sqlcmd.Connection = sqlcnn;
                sqlcmd.CommandText = "update Course set عنوان='" + txtCrsCaption.Text + "',کد='" +
                    txtCrsCode.Text + "',[تعداد واحد]='" + cmbCrsUnit.Text + "',گروه='" + txtCrsGroup.Text + "',[تعداد دانشجو]='" + txtCrsStuCount.Text +
                    "',[نوع دانشجو]='" + cmbCrsStuType.Text + "',مراجع='" + txtCrsRef.Text + "',مدرس='" + txtCrsMasterName.Text + "',[کد مدرس]='" + txtCrsMasterCode.Text + "'"
                    + "where کد='" + cmbCrsCode.Text + "'";
                sqlcnn.Open();
                try
                {
                    sqlcmd.ExecuteNonQuery();
                    sqlcmd.CommandText = "update q2 set [کد درس]='" + txtCrsCode.Text + "'" +
                        "where [کد درس]='" + cmbCrsCode.Text + "'";
                    sqlcmd.ExecuteNonQuery();
                    sqlcmd.CommandText = "update q4 set [کد درس]='" + txtCrsCode.Text + "'" +
                        "where [کد درس]='" + cmbCrsCode.Text + "'";
                    sqlcmd.ExecuteNonQuery();
                    sqlcmd.CommandText = "update Examination set [کد درس]='" + txtCrsCode.Text + "'" +
                        "where [کد درس]='" + cmbCrsCode.Text + "'";
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
                        MessageBox.Show("کد درس قبلا وارد شده است.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    else
                        MessageBox.Show(" خطا در وارد کردن مقادیر", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }//else
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
