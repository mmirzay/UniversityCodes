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
    public partial class Q4List : Form
    {
        public Q4List()
        {
            InitializeComponent();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void Q4List_Load(object sender, EventArgs e)
        {
            this.SetBounds(20, 30, this.Width, this.Height);
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select * from q4";
            SqlDataAdapter sqlda = new SqlDataAdapter(sqlcmd);
            sqlcnn.Open();
            DataTable dt = new DataTable();
            sqlda.Fill(dt);
            dtgv.DataSource = dt;
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
        }
    }
}
