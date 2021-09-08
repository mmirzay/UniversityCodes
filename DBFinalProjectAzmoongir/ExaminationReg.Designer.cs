namespace Azmoongir
{
    partial class ExaminationReg
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.grbCourse = new System.Windows.Forms.GroupBox();
            this.txtCrsMasterName = new System.Windows.Forms.TextBox();
            this.label14 = new System.Windows.Forms.Label();
            this.txtCrsCaption = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.cmbCrsCode = new System.Windows.Forms.ComboBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.rdbQ4 = new System.Windows.Forms.RadioButton();
            this.rdbQ2 = new System.Windows.Forms.RadioButton();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.txtExamMajor = new System.Windows.Forms.TextBox();
            this.txtExamCode = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.btnCancel = new System.Windows.Forms.Button();
            this.btnSave = new System.Windows.Forms.Button();
            this.label8 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.txtQCount = new System.Windows.Forms.TextBox();
            this.grbCourse.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // grbCourse
            // 
            this.grbCourse.Controls.Add(this.txtQCount);
            this.grbCourse.Controls.Add(this.label5);
            this.grbCourse.Controls.Add(this.txtCrsMasterName);
            this.grbCourse.Controls.Add(this.label14);
            this.grbCourse.Controls.Add(this.txtCrsCaption);
            this.grbCourse.Controls.Add(this.label1);
            this.grbCourse.Controls.Add(this.label2);
            this.grbCourse.Controls.Add(this.cmbCrsCode);
            this.grbCourse.Enabled = false;
            this.grbCourse.Location = new System.Drawing.Point(3, 66);
            this.grbCourse.Name = "grbCourse";
            this.grbCourse.Size = new System.Drawing.Size(554, 121);
            this.grbCourse.TabIndex = 2;
            this.grbCourse.TabStop = false;
            this.grbCourse.Text = "درس";
            // 
            // txtCrsMasterName
            // 
            this.txtCrsMasterName.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.txtCrsMasterName.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtCrsMasterName.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtCrsMasterName.ForeColor = System.Drawing.Color.Yellow;
            this.txtCrsMasterName.Location = new System.Drawing.Point(9, 48);
            this.txtCrsMasterName.Name = "txtCrsMasterName";
            this.txtCrsMasterName.ReadOnly = true;
            this.txtCrsMasterName.Size = new System.Drawing.Size(179, 27);
            this.txtCrsMasterName.TabIndex = 0;
            this.txtCrsMasterName.TabStop = false;
            this.txtCrsMasterName.Text = "کد درس را انتخاب کنید";
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label14.Location = new System.Drawing.Point(194, 51);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(83, 20);
            this.label14.TabIndex = 11;
            this.label14.Text = "نام مدرس :";
            // 
            // txtCrsCaption
            // 
            this.txtCrsCaption.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.txtCrsCaption.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtCrsCaption.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtCrsCaption.ForeColor = System.Drawing.Color.Yellow;
            this.txtCrsCaption.Location = new System.Drawing.Point(283, 48);
            this.txtCrsCaption.Name = "txtCrsCaption";
            this.txtCrsCaption.ReadOnly = true;
            this.txtCrsCaption.Size = new System.Drawing.Size(179, 27);
            this.txtCrsCaption.TabIndex = 2;
            this.txtCrsCaption.TabStop = false;
            this.txtCrsCaption.Text = "کد درس را انتخاب کنید";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(491, 51);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(59, 20);
            this.label1.TabIndex = 9;
            this.label1.Text = "عنوان :";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(477, 17);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(73, 20);
            this.label2.TabIndex = 8;
            this.label2.Text = "کد درس :";
            // 
            // cmbCrsCode
            // 
            this.cmbCrsCode.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbCrsCode.FormattingEnabled = true;
            this.cmbCrsCode.Location = new System.Drawing.Point(341, 17);
            this.cmbCrsCode.Name = "cmbCrsCode";
            this.cmbCrsCode.Size = new System.Drawing.Size(121, 24);
            this.cmbCrsCode.TabIndex = 1;
            this.cmbCrsCode.SelectedIndexChanged += new System.EventHandler(this.cmbCrsCode_SelectedIndexChanged);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.rdbQ4);
            this.groupBox2.Controls.Add(this.rdbQ2);
            this.groupBox2.Location = new System.Drawing.Point(3, 3);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(554, 57);
            this.groupBox2.TabIndex = 1;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "نوع آزمون ";
            // 
            // rdbQ4
            // 
            this.rdbQ4.AutoSize = true;
            this.rdbQ4.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rdbQ4.Location = new System.Drawing.Point(9, 21);
            this.rdbQ4.Name = "rdbQ4";
            this.rdbQ4.Size = new System.Drawing.Size(181, 24);
            this.rdbQ4.TabIndex = 2;
            this.rdbQ4.Text = "سوالات چهار گزینه ایی";
            this.rdbQ4.UseVisualStyleBackColor = true;
            this.rdbQ4.CheckedChanged += new System.EventHandler(this.rdbQ4_CheckedChanged);
            // 
            // rdbQ2
            // 
            this.rdbQ2.AutoSize = true;
            this.rdbQ2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rdbQ2.Location = new System.Drawing.Point(382, 21);
            this.rdbQ2.Name = "rdbQ2";
            this.rdbQ2.Size = new System.Drawing.Size(164, 24);
            this.rdbQ2.TabIndex = 1;
            this.rdbQ2.Text = "سوالات دو گزینه ایی";
            this.rdbQ2.UseVisualStyleBackColor = true;
            this.rdbQ2.CheckedChanged += new System.EventHandler(this.rdbQ2_CheckedChanged);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.txtExamMajor);
            this.groupBox1.Controls.Add(this.txtExamCode);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Location = new System.Drawing.Point(3, 193);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(554, 62);
            this.groupBox1.TabIndex = 3;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "مشخصات آزمون";
            // 
            // txtExamMajor
            // 
            this.txtExamMajor.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtExamMajor.Location = new System.Drawing.Point(9, 24);
            this.txtExamMajor.Name = "txtExamMajor";
            this.txtExamMajor.Size = new System.Drawing.Size(179, 27);
            this.txtExamMajor.TabIndex = 2;
            // 
            // txtExamCode
            // 
            this.txtExamCode.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtExamCode.Location = new System.Drawing.Point(283, 24);
            this.txtExamCode.Name = "txtExamCode";
            this.txtExamCode.Size = new System.Drawing.Size(179, 27);
            this.txtExamCode.TabIndex = 1;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(225, 27);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(52, 20);
            this.label4.TabIndex = 13;
            this.label4.Text = "رشته :";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(463, 27);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(82, 20);
            this.label3.TabIndex = 12;
            this.label3.Text = "کد آزمون :";
            // 
            // btnCancel
            // 
            this.btnCancel.AutoSize = true;
            this.btnCancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnCancel.Location = new System.Drawing.Point(371, 262);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(81, 30);
            this.btnCancel.TabIndex = 5;
            this.btnCancel.Text = "انصراف";
            this.btnCancel.UseVisualStyleBackColor = true;
            // 
            // btnSave
            // 
            this.btnSave.AutoSize = true;
            this.btnSave.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSave.Location = new System.Drawing.Point(468, 262);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(81, 30);
            this.btnSave.TabIndex = 4;
            this.btnSave.Text = "ثبت";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label8.ForeColor = System.Drawing.Color.Red;
            this.label8.Location = new System.Drawing.Point(3, 262);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(239, 20);
            this.label8.TabIndex = 21;
            this.label8.Text = "لطفا از حروف فارسی استفاده نکنید.";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(445, 87);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(105, 20);
            this.label5.TabIndex = 12;
            this.label5.Text = "تعداد سوالات :";
            // 
            // txtQCount
            // 
            this.txtQCount.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.txtQCount.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtQCount.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtQCount.ForeColor = System.Drawing.Color.Yellow;
            this.txtQCount.Location = new System.Drawing.Point(283, 85);
            this.txtQCount.Name = "txtQCount";
            this.txtQCount.ReadOnly = true;
            this.txtQCount.Size = new System.Drawing.Size(156, 27);
            this.txtQCount.TabIndex = 13;
            this.txtQCount.TabStop = false;
            this.txtQCount.Text = "کد درس را انتخاب کنید";
            // 
            // ExaminationReg
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(560, 304);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.btnSave);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.grbCourse);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "ExaminationReg";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Text = "ثبت آزمون";
            this.Load += new System.EventHandler(this.ExaminationReg_Load);
            this.grbCourse.ResumeLayout(false);
            this.grbCourse.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox grbCourse;
        private System.Windows.Forms.TextBox txtCrsMasterName;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.TextBox txtCrsCaption;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox cmbCrsCode;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.RadioButton rdbQ4;
        private System.Windows.Forms.RadioButton rdbQ2;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtExamMajor;
        private System.Windows.Forms.TextBox txtExamCode;
        private System.Windows.Forms.Button btnCancel;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox txtQCount;
        private System.Windows.Forms.Label label5;
    }
}