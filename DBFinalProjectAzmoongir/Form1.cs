using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Azmoongir
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void timer_Tick(object sender, EventArgs e)
        {           
            MoMo.SetBounds(MoMo.Bounds.X-1, MoMo.Bounds.Y , MoMo.Width, MoMo.Height);
            if (MoMo.Bounds.X <= 0 - MoMo.Width)
                MoMo.SetBounds(this.Width,MoMo.Bounds.Y,MoMo.Width,MoMo.Height);
        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            timer.Enabled = true;
            panel1.Width = this.Width;
            new Login().ShowDialog();
        }

        private void ثبتدرسToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new CourceReg().ShowDialog() ;
        }

        private void ثبتدانشجوToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new StuReg().ShowDialog();
        }

        private void ثبتسوالToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            new DualAnswer().ShowDialog();
        }

        private void لیستدروسToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            new CourseList().ShowDialog();
        }

        private void لیستدانشجوToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            new StudentList().ShowDialog();
        }

        private void لیستسوالاتToolStripMenuItem3_Click(object sender, EventArgs e)
        {
            new Q2List().ShowDialog();
        }

        private void ثبتسوالToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new QuaAnswer().ShowDialog();
        }

        private void لیستسوالاتToolStripMenuItem2_Click(object sender, EventArgs e)
        {
            new Q4List().ShowDialog();
        }

        private void ویرایشدرسToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new CourseEditing().ShowDialog();
        }

        private void MoMo_MouseEnter(object sender, EventArgs e)
        {
            timer.Enabled = false;
            MoMo.ForeColor = Color.Red;
        }

        private void MoMo_MouseLeave(object sender, EventArgs e)
        {
            timer.Enabled = true;
            MoMo.ForeColor = Color.White;
        }

        private void حذفدرسToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new CourseDeleting().ShowDialog();
        }

        private void ویرایشدانشجوToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new StudentEditing().ShowDialog();
        }

        private void حذفدانشجوToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new StudenDeleting().ShowDialog();
        }

        private void ویرایشسوالToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Q4Editing().ShowDialog();
        }

        private void حذفسوالToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Q4Deleting().ShowDialog();
        }

        private void ویرایشسوالToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            new Q2Editing().ShowDialog();
        }

        private void حذفسوالToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            new Q2Deleting().ShowDialog();
        }

        private void ثبتآزمونToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new ExaminationReg().ShowDialog();
        }

        private void رگزاریآزمونToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new ExaminationEditing().ShowDialog();
        }

        private void نتایجآزمونToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            new ExaminationDeleting().ShowDialog();
        }

        private void لیستآزمونToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new ExaminationList().ShowDialog();
        }

        private void بازگشتبهصفحهیورودToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Login().ShowDialog();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            DialogResult res = MessageBox.Show("آیا مطمئن هستید؟", "خروج", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (res == DialogResult.Yes)
            {
                Application.Exit();
            }
        }        
    }
}
