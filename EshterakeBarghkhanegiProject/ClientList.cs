using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace tamrine_11
{
    public partial class ClientList : Form
    {
        public ClientList()
        {
            InitializeComponent();
        }

        private void ClientList_Load(object sender, EventArgs e)
        {
            DataTable dtHome = new DataTable();
            dtHome.Columns.Add("نام کاربری");
            dtHome.Columns.Add("نام");
            dtHome.Columns.Add("نام خانوادگی");
            dtHome.Columns.Add("کد ملی");
            dtHome.Columns.Add("کد پستی");
            dtHome.Columns.Add("شماره تماس");
            dtHome.Columns.Add("تعداد واحد");
            FileStream fsr = new FileStream("home_client.txt", FileMode.OpenOrCreate, FileAccess.Read);
            StreamReader srr = new StreamReader(fsr);
            String line = srr.ReadLine();
            while (line != null)
            {
                String[] client = line.Split(',');
                dtHome.Rows.Add(client[0], client[1], client[2], client[3], client[4], client[5], client[6]);
                line = srr.ReadLine();
            }
            dgvHome.DataSource = dtHome;
            srr.Close();
            fsr.Close();

            DataTable dtOrg = new DataTable();
            dtOrg.Columns.Add("نام کاربری");
            dtOrg.Columns.Add("نام سازمان");
            dtOrg.Columns.Add("نوع سازمان");
            dtOrg.Columns.Add("کد پستی");
            dtOrg.Columns.Add("کد ملی نماینده");
            dtOrg.Columns.Add("شماره تماس");
            FileStream fsrOrg = new FileStream("organization_client.txt", FileMode.OpenOrCreate, FileAccess.Read);
            StreamReader srrOrg = new StreamReader(fsrOrg);
            String lineOrg = srrOrg.ReadLine();
            while (lineOrg != null)
            {
                String[] clientOrg = lineOrg.Split(',');
                dtOrg.Rows.Add(clientOrg[0], clientOrg[1], clientOrg[2], clientOrg[3], clientOrg[4], clientOrg[5]);
                lineOrg = srrOrg.ReadLine();
            }
            dgvOrg.DataSource = dtOrg;
            srrOrg.Close();
            fsrOrg.Close();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        public void deleteFromFile(String fn, String cnum)
        {
            FileStream fs = new FileStream(fn, FileMode.OpenOrCreate, FileAccess.ReadWrite);
            FileStream fs2 = new FileStream("temp.txt", FileMode.Create, FileAccess.Write);
            StreamReader fsrr = new StreamReader(fs);
            StreamWriter fsw = new StreamWriter(fs2);
            String linee = fsrr.ReadLine();
            while (linee != null)
            {
                String[] client = linee.Split(',');
                if (cnum.Equals(client[0]))
                { }
                else
                    fsw.WriteLine(linee);
                linee = fsrr.ReadLine();
            }
            fsrr.Close();
            fsw.Close();
            fs.Close();
            fs2.Close();
            File.Delete(fn);
            File.Move("temp.txt", fn);
            File.Delete("temp.txt");
            DataTable dtHome = new DataTable();
            dtHome.Columns.Add("نام کاربری");
            dtHome.Columns.Add("نام");
            dtHome.Columns.Add("نام خانوادگی");
            dtHome.Columns.Add("کد ملی");
            dtHome.Columns.Add("کد پستی");
            dtHome.Columns.Add("شماره تماس");
            dtHome.Columns.Add("تعداد واحد");

            FileStream fsr = new FileStream("home_client.txt", FileMode.OpenOrCreate, FileAccess.Read);
            StreamReader srr = new StreamReader(fsr);
            String line = srr.ReadLine();
            while (line != null)
            {
                String[] client = line.Split(',');
                dtHome.Rows.Add(client[0], client[1], client[2], client[3], client[4], client[5], client[6]);
                line = srr.ReadLine();
            }
            dgvHome.DataSource = dtHome;
            srr.Close();
            fsr.Close();

            DataTable dtOrg = new DataTable();
            dtOrg.Columns.Add("نام کاربری");
            dtOrg.Columns.Add("نام سازمان");
            dtOrg.Columns.Add("نوع سازمان");
            dtOrg.Columns.Add("کد پستی");
            dtOrg.Columns.Add("کد ملی نماینده");
            dtOrg.Columns.Add("شماره تماس");
            FileStream fsrOrg = new FileStream("organization_client.txt", FileMode.OpenOrCreate, FileAccess.Read);
            StreamReader srrOrg = new StreamReader(fsrOrg);
            String lineOrg = srrOrg.ReadLine();
            while (lineOrg != null)
            {
                String[] clientOrg = lineOrg.Split(',');
                dtOrg.Rows.Add(clientOrg[0], clientOrg[1], clientOrg[2], clientOrg[3], clientOrg[4], clientOrg[5]);
                lineOrg = srrOrg.ReadLine();
            }
            dgvOrg.DataSource = dtOrg;
            srrOrg.Close();
            fsrOrg.Close();

        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (tcShow.SelectedIndex == 0)
            {
                if (dgvHome.CurrentRow == null)
                    MessageBox.Show("موردی انتخاب نشده است!", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                else
                {                                        
                    String hcnum = dgvHome.CurrentRow.Cells[0].Value.ToString();                    
                    MessageBox.Show("اطلاعات مشترک حذف گردید.", "ثبت اطلاعات", MessageBoxButtons.OK, MessageBoxIcon.Information,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                    deleteFromFile("home_client.txt", hcnum);
                    deleteFromFile("user_account.txt", hcnum);
                }
            }
            else
            {
                if (dgvOrg.CurrentRow == null)
                    MessageBox.Show("موردی انتخاب نشده است!", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                else
                {                    
                    String ocnum = dgvOrg.CurrentRow.Cells[0].Value.ToString();                    
                    MessageBox.Show("اطلاعات مشترک حذف گردید.", "ثبت اطلاعات", MessageBoxButtons.OK, MessageBoxIcon.Information,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                    deleteFromFile("organization_client.txt", ocnum);
                    deleteFromFile("user_account.txt", ocnum);
                }
            }
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            if (tcShow.SelectedIndex == 0)
            {
                if (dgvHome.CurrentRow == null)
                    MessageBox.Show("موردی انتخاب نشده است!", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                else
                {
                    String hcnum = dgvHome.CurrentRow.Cells[0].Value.ToString();
                    this.Dispose();
                    new HomeClientEdit(hcnum).ShowDialog();
                }
            }
            else
            {
                if (dgvOrg.CurrentRow == null)
                    MessageBox.Show("موردی انتخاب نشده است!", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                else
                {
                    String ocnum = dgvOrg.CurrentRow.Cells[0].Value.ToString();
                    this.Dispose();
                    new OrgClientEdit(ocnum).ShowDialog();                   
                }
            }
        }// method
    }
}
