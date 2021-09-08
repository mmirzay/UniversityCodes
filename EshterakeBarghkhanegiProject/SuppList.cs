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
    public partial class SuppList : Form
    {
        public SuppList()
        {
            InitializeComponent();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void SuppList_Load(object sender, EventArgs e)
        {
            DataTable dtHome = new DataTable();
            dtHome.Columns.Add("نام کاربری");
            dtHome.Columns.Add("نام");
            dtHome.Columns.Add("نام خانوادگی");
            dtHome.Columns.Add("کد ملی");
            dtHome.Columns.Add("کد پستی");
            dtHome.Columns.Add("شماره تماس");
            dtHome.Columns.Add("تعداد واحد");
            FileStream fsr = new FileStream("home_suppliant.txt", FileMode.OpenOrCreate, FileAccess.Read);
            StreamReader srr = new StreamReader(fsr);
            String line = srr.ReadLine();
            while (line != null)
            {
                String[] client = line.Split(',');
                dtHome.Rows.Add(client[0], client[1], client[2], client[3], client[4], client[5],client[6]);
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
            FileStream fsrOrg = new FileStream("organization_suppliant.txt", FileMode.OpenOrCreate, FileAccess.Read);
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

            FileStream fsr = new FileStream("home_suppliant.txt", FileMode.OpenOrCreate, FileAccess.Read);
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
            FileStream fsrOrg = new FileStream("organization_suppliant.txt", FileMode.OpenOrCreate, FileAccess.Read);
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
        private void btnConfirm_Click(object sender, EventArgs e)
        {
            if (tcShow.SelectedIndex == 0)
            {
                if(dgvHome.CurrentRow==null)
                    MessageBox.Show("موردی انتخاب نشده است!", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                else{
                    FileStream fsHome = new FileStream("home_client.txt", FileMode.Append, FileAccess.Write);
                    StreamWriter swHome = new StreamWriter(fsHome);
                    String hcnum = dgvHome.CurrentRow.Cells[0].Value.ToString();
                    String hname = dgvHome.CurrentRow.Cells[1].Value.ToString();
                    String hlname = dgvHome.CurrentRow.Cells[2].Value.ToString();
                    String hid = dgvHome.CurrentRow.Cells[3].Value.ToString();
                    String hpost = dgvHome.CurrentRow.Cells[4].Value.ToString();
                    String htel = dgvHome.CurrentRow.Cells[5].Value.ToString();
                    String hunit = dgvHome.CurrentRow.Cells[6].Value.ToString();

                    swHome.WriteLine(hcnum + "," + hname + "," + hlname + "," + hid + "," + hpost + ","+htel +","+hunit);
                    swHome.Close();
                    fsHome.Close();                    
                    MessageBox.Show("اطلاعات مشترک تایید گردید.","ثبت اطلاعات", MessageBoxButtons.OK, MessageBoxIcon.Information,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                    deleteFromFile("home_suppliant.txt", hcnum);
                }
            }
            else
            {
                if (dgvOrg.CurrentRow == null)
                    MessageBox.Show("موردی انتخاب نشده است!", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                else
                {
                    FileStream fsOrg = new FileStream("organization_client.txt", FileMode.Append, FileAccess.Write);
                    StreamWriter swOrg = new StreamWriter(fsOrg);
                    String ocnum = dgvOrg.CurrentRow.Cells[0].Value.ToString();
                    String oname = dgvOrg.CurrentRow.Cells[1].Value.ToString();
                    String otype = dgvOrg.CurrentRow.Cells[2].Value.ToString();
                    String opost = dgvOrg.CurrentRow.Cells[3].Value.ToString();
                    String oid = dgvOrg.CurrentRow.Cells[4].Value.ToString();
                    String otel = dgvOrg.CurrentRow.Cells[5].Value.ToString();

                    swOrg.WriteLine(ocnum + "," + oname + "," + otype + "," + opost + "," + oid + "," + otel);
                    swOrg.Close();
                    fsOrg.Close();
                    MessageBox.Show("اطلاعات مشترک تایید گردید.", "ثبت اطلاعات", MessageBoxButtons.OK, MessageBoxIcon.Information,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                    deleteFromFile("organization_suppliant.txt", ocnum);                    
                }
            }
        }

        private void dgvOrg_SelectionChanged(object sender, EventArgs e)
        {
            btnConfirm.Enabled = true;
        }

        private void dgvHome_SelectionChanged(object sender, EventArgs e)
        {
            btnConfirm.Enabled = true;
        }

        private void dgvHome_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            btnConfirm.Enabled = true;
        }

        private void dgvOrg_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            btnConfirm.Enabled = true;
        }

        private void dgvOrg_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            btnConfirm.Enabled = true;
        }

        private void dgvHome_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            btnConfirm.Enabled = true;
        }
    }
}
